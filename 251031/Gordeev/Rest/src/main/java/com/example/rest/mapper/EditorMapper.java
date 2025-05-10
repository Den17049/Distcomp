package com.example.rest.mapper;

import com.example.rest.dto.EditorRequestTo;

import com.example.rest.dto.EditorResponseTo;
import com.example.rest.entity.Editor;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditorMapper {
    Editor toEntity(EditorRequestTo editorRequestTo);
    EditorResponseTo toResponse(Editor editor);
}

