package com.abc.grpc.controller;

import com.abc.grpc.custom_anotation.monitor.Monitor;
import com.abc.grpc.dto.PostDTO;
import com.abc.grpc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class Controller {
    @Autowired
    private PostService service;
    @GetMapping
    public List<PostDTO> getList () {
        return service.getListPost();
    }

    @PostMapping
    @Monitor(name = "insert_post", type = "rest_api")
    public PostDTO insertPost (@Validated @RequestBody PostDTO dto) {
        return service.insertPost(dto);
    }


}
