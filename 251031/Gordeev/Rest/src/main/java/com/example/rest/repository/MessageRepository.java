package com.example.rest.repository;

import com.example.rest.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Message create(Message message);
    Message update(Message message);
    void deleteById(Long id);
    Optional<Message> findById(Long id);
    List<Message> findAll();
}
