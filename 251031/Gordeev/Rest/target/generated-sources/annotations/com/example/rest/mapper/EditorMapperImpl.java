package com.example.rest.mapper;

import com.example.rest.dto.EditorRequestTo;
import com.example.rest.dto.EditorResponseTo;
import com.example.rest.entity.Editor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-05T21:10:10+0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class EditorMapperImpl implements EditorMapper {

    @Override
    public Editor toEntity(EditorRequestTo editorRequestTo) {
        if ( editorRequestTo == null ) {
            return null;
        }

        Editor editor = new Editor();

        editor.setId( editorRequestTo.getId() );
        editor.setLogin( editorRequestTo.getLogin() );
        editor.setPassword( editorRequestTo.getPassword() );
        editor.setFirstname( editorRequestTo.getFirstname() );
        editor.setLastname( editorRequestTo.getLastname() );

        return editor;
    }

    @Override
    public EditorResponseTo toResponse(Editor editor) {
        if ( editor == null ) {
            return null;
        }

        EditorResponseTo editorResponseTo = new EditorResponseTo();

        editorResponseTo.setId( editor.getId() );
        editorResponseTo.setLogin( editor.getLogin() );
        editorResponseTo.setPassword( editor.getPassword() );
        editorResponseTo.setFirstname( editor.getFirstname() );
        editorResponseTo.setLastname( editor.getLastname() );

        return editorResponseTo;
    }
}
