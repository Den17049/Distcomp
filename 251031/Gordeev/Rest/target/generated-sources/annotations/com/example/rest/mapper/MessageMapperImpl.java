package com.example.rest.mapper;

import com.example.rest.dto.MessageRequestTo;
import com.example.rest.dto.MessageResponseTo;
import com.example.rest.entity.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-05T21:10:09+0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message toEntity(MessageRequestTo dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( dto.getId() );
        message.setContent( dto.getContent() );
        message.setNewsId( dto.getNewsId() );

        return message;
    }

    @Override
    public MessageResponseTo toResponse(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageResponseTo messageResponseTo = new MessageResponseTo();

        messageResponseTo.setId( entity.getId() );
        messageResponseTo.setContent( entity.getContent() );
        messageResponseTo.setNewsId( entity.getNewsId() );

        return messageResponseTo;
    }
}
