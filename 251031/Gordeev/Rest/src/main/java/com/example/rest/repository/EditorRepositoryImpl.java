package com.example.rest.repository;

import com.example.rest.entity.Editor;
import org.springframework.stereotype.Repository;
import com.example.rest.mapper.EditorMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;
@Repository
public class EditorRepositoryImpl implements EditorRepository {

    private final Map<Long, Editor> editors = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Editor create(Editor editor) {
        editor.setId(nextId++);
        editors.put(editor.getId(), editor);
        return editor;
    }

    @Override
    public Editor update(Editor editor) {
        if (!editors.containsKey(editor.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editor not found");
        }
        editors.put(editor.getId(), editor);  // обновляем запись
        return editor;
    }

    @Override
    public void deleteById(Long id) {
        if (!editors.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editor not found");
        }
        editors.remove(id);
    }


    @Override
    public List<Editor> findAll() {
        return new ArrayList<>(editors.values());
    }

    @Override
    public Optional<Editor> findById(Long id) {
        return Optional.ofNullable(editors.get(id));
    }
}
