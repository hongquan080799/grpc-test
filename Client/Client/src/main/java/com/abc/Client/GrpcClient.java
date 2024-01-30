package com.abc.Client;

import com.abc.Client.monitor.Monitor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;
import post.MyServiceGrpc;
import post.Post;

import java.util.UUID;

@Component
public class GrpcClient {
    private MyServiceGrpc.MyServiceBlockingStub stub;
    public GrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        stub = MyServiceGrpc.newBlockingStub(channel);
    }
    @Monitor(name = "insert_post", type = "grpc")
    public void sendTest() {
        Post.PostMessage message = initMessage();
        Post.PostResponseMessage response = stub.insertPost(message);
        System.out.printf("Response : %s\n", response.getIsSuccess());
    }
    private Post.PostMessage initMessage() {
        return Post.PostMessage.newBuilder()
                .setTitle(UUID.randomUUID().toString())
                .setBody(UUID.randomUUID().toString())
                .setPerson(UUID.randomUUID().toString())
                .setField1(UUID.randomUUID().toString())
                .setField2(UUID.randomUUID().toString())
                .setField3(UUID.randomUUID().toString())
                .setField4(UUID.randomUUID().toString())
                .setField5(UUID.randomUUID().toString())
                .setField6(UUID.randomUUID().toString())
                .setField7(UUID.randomUUID().toString())
                .setField8(UUID.randomUUID().toString())
                .setField9(UUID.randomUUID().toString())
                .setField10(UUID.randomUUID().toString())
                .setField11(UUID.randomUUID().toString())
                .setField12(UUID.randomUUID().toString())
                .setField13(UUID.randomUUID().toString())
                .setField14(UUID.randomUUID().toString())
                .setField15(UUID.randomUUID().toString())
                .setField16(UUID.randomUUID().toString())
                .setField17(UUID.randomUUID().toString())
                .setField18(UUID.randomUUID().toString())
                .setField19(UUID.randomUUID().toString())
                .setField20(UUID.randomUUID().toString())
                .build();
    }
}
