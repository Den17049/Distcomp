package com.example.rest.repository;

import com.example.rest.entity.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Repository
public class TagRepositoryIml implements TagRepository {

    private final Map<Long, Tag> tags = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Tag create(Tag tag) {
        tag.setId(nextId++);
        tags.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public Tag update(Tag updatedTag) {
        if (!tags.containsKey(updatedTag.getId())) {
            throw new IllegalArgumentException("Tag with ID " + updatedTag.getId() + " not found");
        }
        tags.put(updatedTag.getId(), updatedTag);
        return updatedTag;
    }

    @Override
    public void deleteById(Long id) {
        if (!tags.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editor not found");
        }
        tags.remove(id);

    }

    @Override
    public List<Tag> findAll() {
        return tags.values().stream().toList();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return Optional.ofNullable(tags.get(id));
    }
}