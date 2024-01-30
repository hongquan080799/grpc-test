package com.abc.grpc.mapper;

import com.abc.grpc.dto.PostDTO;
import com.abc.grpc.entity.Post;
import javax.annotation.processing.Generated;
import post.Post.PostMessage;
import post.Post.PostMessage.Builder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T17:50:13+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDTO protoToDTO(PostMessage message) {
        if ( message == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( (long) message.getId() );
        if ( message.getTitle() != null ) {
            postDTO.setTitle( message.getTitle() );
        }
        if ( message.getBody() != null ) {
            postDTO.setBody( message.getBody() );
        }
        if ( message.getPerson() != null ) {
            postDTO.setPerson( message.getPerson() );
        }

        return postDTO;
    }

    @Override
    public Post dtoToEntity(PostDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Post post = new Post();

        if ( dto.getId() != null ) {
            post.setId( dto.getId() );
        }
        if ( dto.getTitle() != null ) {
            post.setTitle( dto.getTitle() );
        }
        if ( dto.getBody() != null ) {
            post.setBody( dto.getBody() );
        }
        if ( dto.getPerson() != null ) {
            post.setPerson( dto.getPerson() );
        }

        return post;
    }

    @Override
    public PostDTO entityToDTO(Post entity) {
        if ( entity == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        if ( entity.getId() != null ) {
            postDTO.setId( entity.getId() );
        }
        if ( entity.getTitle() != null ) {
            postDTO.setTitle( entity.getTitle() );
        }
        if ( entity.getBody() != null ) {
            postDTO.setBody( entity.getBody() );
        }
        if ( entity.getPerson() != null ) {
            postDTO.setPerson( entity.getPerson() );
        }

        return postDTO;
    }

    @Override
    public PostMessage dtoToProto(PostDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Builder postMessage = PostMessage.newBuilder();

        if ( dto.getId() != null ) {
            postMessage.setId( dto.getId().intValue() );
        }
        if ( dto.getTitle() != null ) {
            postMessage.setTitle( dto.getTitle() );
        }
        if ( dto.getBody() != null ) {
            postMessage.setBody( dto.getBody() );
        }
        if ( dto.getPerson() != null ) {
            postMessage.setPerson( dto.getPerson() );
        }

        return postMessage.build();
    }

    @Override
    public PostMessage entityToProto(Post entity) {
        if ( entity == null ) {
            return null;
        }

        Builder postMessage = PostMessage.newBuilder();

        if ( entity.getId() != null ) {
            postMessage.setId( entity.getId().intValue() );
        }
        if ( entity.getTitle() != null ) {
            postMessage.setTitle( entity.getTitle() );
        }
        if ( entity.getBody() != null ) {
            postMessage.setBody( entity.getBody() );
        }
        if ( entity.getPerson() != null ) {
            postMessage.setPerson( entity.getPerson() );
        }

        return postMessage.build();
    }
}
