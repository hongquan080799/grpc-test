package com.abc.grpc.service;


import com.abc.grpc.dto.ParentDTO;
import com.abc.grpc.entity.Parent;
import com.abc.grpc.mapper.ParentMapper;
import com.abc.grpc.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    private ParentRepository parentRepository;
    public List<ParentDTO> getListParent () {

        List<Parent> list = parentRepository.findAll();
        return list.stream().map(ParentMapper.INSTANCE::map).toList();
    }

    @Transactional
    public ParentDTO insertParent(ParentDTO dto) {
        Parent entity = ParentMapper.INSTANCE.map(dto);
        var savedEntity =  parentRepository.save(entity);
        return ParentMapper.INSTANCE.map(savedEntity);
    }
}
