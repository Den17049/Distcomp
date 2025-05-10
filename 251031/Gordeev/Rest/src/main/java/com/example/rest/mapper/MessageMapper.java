package com.example.rest.mapper;

import com.example.rest.dto.MessageRequestTo;
import com.example.rest.dto.MessageResponseTo;
import com.example.rest.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toEntity(MessageRequestTo dto);
    MessageResponseTo toResponse(Message entity);
}
