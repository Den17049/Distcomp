package com.example.rest.service;

import com.example.rest.dto.MessageRequestTo;
import com.example.rest.dto.MessageResponseTo;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    MessageResponseTo create(MessageRequestTo message);
    MessageResponseTo update(MessageResponseTo message);
    void deleteById(Long id);
    Optional<MessageResponseTo> findById(Long id);
    List<MessageResponseTo> findAll();
}
