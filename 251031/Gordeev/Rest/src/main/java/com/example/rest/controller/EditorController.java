package com.example.rest.controller;


import com.example.rest.dto.EditorRequestTo;
import com.example.rest.dto.EditorResponseTo;

import com.example.rest.dto.EditorUpdate;

import com.example.rest.service.EditorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/editors")
public class EditorController {

    private final EditorService editorService;

    @Autowired
    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @GetMapping
    public ResponseEntity<List<EditorResponseTo>> findAll() {
        return ResponseEntity.ok(editorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorResponseTo> findById(@PathVariable Long id) {
        Optional<EditorResponseTo> editor = editorService.findById(id);
        return editor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EditorResponseTo> create(@Valid @RequestBody EditorRequestTo request) {
        EditorResponseTo response = editorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorResponseTo> updateEditor(@PathVariable Long id, @RequestBody EditorUpdate dto) {
        dto.setId(id);  // Добавляем id из URL в тело запроса
        EditorResponseTo response = editorService.update(dto);
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<EditorResponseTo> updateEditorWithoutPathId(@Valid @RequestBody EditorUpdate dto) {
        EditorResponseTo response = editorService.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        editorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
