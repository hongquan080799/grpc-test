package com.abc.grpc.controller;

import com.abc.grpc.dto.ParentDTO;
import com.abc.grpc.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired
    private ParentService parentService;
    @GetMapping
    public List<ParentDTO> getAllParent() {
        return parentService.getListParent();
    }
    @PostMapping
    public ParentDTO insertParent(@Validated @RequestBody ParentDTO dto) {
        return parentService.insertParent(dto);
    }
}
