package com.abc.grpc.controller;

import com.abc.grpc.custom_anotation.monitor.Monitor;
import com.abc.grpc.dto.PostDTO;
import com.abc.grpc.mapper.PostMapper;
import com.abc.grpc.service.PostService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import post.MyServiceGrpc;
import post.Post;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class GrpcController extends MyServiceGrpc.MyServiceImplBase {

    @Autowired
    private PostService service;

    @Override
    @Monitor(name = "insert_post", type = "grpc")
    public void insertPost(Post.PostMessage request, StreamObserver<Post.PostResponseMessage> responseObserver) {
        PostDTO dto = PostMapper.INSTANCE.protoToDTO(request);
        PostDTO resultDto = service.insertPost(dto);
        responseObserver.onNext(Post.PostResponseMessage.newBuilder()
                .setIsSuccess(true)
                .build());
        responseObserver.onCompleted();

    }

    @Override
    public void getListPost(Post.GetListPostRequestMessage request, StreamObserver<Post.GetListPostResponseMessage> responseObserver) {
        List<PostDTO> list = service.getListPost();
        Post.GetListPostResponseMessage response = Post.GetListPostResponseMessage.newBuilder()
                .addAllList(list.stream().map(PostMapper.INSTANCE::dtoToProto).collect(Collectors.toList()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
