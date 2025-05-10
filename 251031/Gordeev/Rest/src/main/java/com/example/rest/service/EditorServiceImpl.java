package com.example.rest.service;

import com.example.rest.dto.EditorRequestTo;
import com.example.rest.dto.EditorResponseTo;
import com.example.rest.dto.EditorUpdate;
import com.example.rest.entity.Editor;
import com.example.rest.mapper.EditorMapper;
import com.example.rest.repository.EditorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditorServiceImpl implements EditorService {

    private EditorRepository editorRepository;
    private EditorMapper editorMapper;

    @Autowired
    public EditorServiceImpl(EditorRepository editorRepository, EditorMapper editorMapper) {
        this.editorRepository = editorRepository;
        this.editorMapper = editorMapper;
    }

    @Override
    public EditorResponseTo create(EditorRequestTo editor) {
        return editorMapper.toResponse(editorRepository.create(editorMapper.toEntity(editor)));

    }

    @Override
    public EditorResponseTo update(EditorUpdate updatedEditor) {
        Editor editor = editorRepository.findById(updatedEditor.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editor not found"));

        if (updatedEditor.getLogin() != null)
            editor.setLogin(updatedEditor.getLogin());

        if (updatedEditor.getPassword() != null)
            editor.setPassword(updatedEditor.getPassword());

        if (updatedEditor.getFirstname() != null)
            editor.setFirstname(updatedEditor.getFirstname());

        if (updatedEditor.getLastname() != null)
            editor.setLastname(updatedEditor.getLastname());

        Editor updated = editorRepository.update(editor);  // обновляем в репозитории
        return editorMapper.toResponse(updated);  // возвращаем результат
    }



    @Override
    public void deleteById(Long id) {
        editorRepository.deleteById(id);
    }



    @Override
    public List<EditorResponseTo> findAll() {
        return editorRepository.findAll()
                .stream()
                .map(editorMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<EditorResponseTo> findById(Long id) {
        return editorRepository.findById(id)
                .map(editorMapper::toResponse);

    }




}
