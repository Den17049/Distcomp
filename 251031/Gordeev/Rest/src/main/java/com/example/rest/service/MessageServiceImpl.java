package com.example.rest.service;

import com.example.rest.dto.MessageRequestTo;
import com.example.rest.dto.MessageResponseTo;
import com.example.rest.entity.Message;
import com.example.rest.mapper.MessageMapper;
import com.example.rest.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    @Override
    public MessageResponseTo create(MessageRequestTo message) {
        Message entity = messageMapper.toEntity(message);
        return messageMapper.toResponse(messageRepository.create(entity));
    }

    @Override
    public MessageResponseTo update(MessageResponseTo messageDto) {
        Message message = messageRepository.findById(messageDto.getId())
                .orElseThrow(() -> new RuntimeException("Message not found"));
        message.setContent(messageDto.getContent());
        message.setNewsId(messageDto.getNewsId());
        return messageMapper.toResponse(messageRepository.update(message));
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Optional<MessageResponseTo> findById(Long id) {
        return messageRepository.findById(id)
                .map(messageMapper::toResponse);
    }

    @Override
    public List<MessageResponseTo> findAll() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toResponse)
                .toList();
    }
}
