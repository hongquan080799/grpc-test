package com.abc.grpc.mapper;


import com.abc.grpc.dto.ParentDTO;
import com.abc.grpc.entity.Parent;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        , collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);


    Parent map (ParentDTO dto);

    ParentDTO map (Parent parent);
}
