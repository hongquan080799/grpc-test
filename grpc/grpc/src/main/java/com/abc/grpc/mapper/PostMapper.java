package com.abc.grpc.mapper;

import com.abc.grpc.dto.PostDTO;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import post.Post;

@Mapper(uses = {}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        , collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO protoToDTO (Post.PostMessage message);
    com.abc.grpc.entity.Post dtoToEntity (PostDTO dto);

    PostDTO entityToDTO (com.abc.grpc.entity.Post entity);

    Post.PostMessage dtoToProto(PostDTO dto);

    Post.PostMessage entityToProto (com.abc.grpc.entity.Post entity);
}
