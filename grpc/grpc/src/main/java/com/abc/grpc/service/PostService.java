package com.abc.grpc.service;

import com.abc.grpc.custom_anotation.monitor.Monitor;
import com.abc.grpc.dto.PostDTO;
import com.abc.grpc.mapper.PostMapper;
import com.abc.grpc.repository.PostRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    @Monitor(name = "insert_post", type = "service")
    public PostDTO insertPost (PostDTO dto) {
        com.abc.grpc.entity.Post entity = PostMapper.INSTANCE.dtoToEntity(dto);
        var savedEntity =  repository.save(entity);
        return PostMapper.INSTANCE.entityToDTO(savedEntity);
    }

    public List<PostDTO> getListPost () {
        List<com.abc.grpc.entity.Post> list = repository.findAll();
        return list.stream().map(PostMapper.INSTANCE::entityToDTO).collect(Collectors.toList());

    }
}
