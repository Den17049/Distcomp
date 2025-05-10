package com.example.rest.service;

import com.example.rest.dto.*;

import java.util.List;
import java.util.Optional;

public interface EditorService {
    EditorResponseTo create(EditorRequestTo editor);

    EditorResponseTo update(EditorUpdate updatedEditor);

    void deleteById(Long id);

    List<EditorResponseTo> findAll();

    Optional<EditorResponseTo> findById(Long id);

}