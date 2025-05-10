package com.example.rest.repository;

import com.example.rest.entity.Editor;

import java.util.List;
import java.util.Optional;

public interface EditorRepository {
    Editor create(Editor editor);
    Editor update(Editor updatedEditor);
    void deleteById(Long id);
    List<Editor> findAll();
    Optional<Editor> findById(Long id);



}
