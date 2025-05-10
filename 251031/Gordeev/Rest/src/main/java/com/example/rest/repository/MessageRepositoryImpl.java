package com.example.rest.repository;

import com.example.rest.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final Map<Long, Message> messages = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Message create(Message message) {
        message.setId(nextId++);
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message update(Message message) {
        if (!messages.containsKey(message.getId())) {
            throw new IllegalArgumentException("Message not found");
        }
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public void deleteById(Long id) {
        messages.remove(id);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(messages.get(id));
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(messages.values());
    }
}
