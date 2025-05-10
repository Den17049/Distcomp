package com.example.rest.dto;

import com.example.rest.entity.Editor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class NewsRequestTo {

    private Long editorId;

    @Size(min = 3, message = "Login must be at least 3 characters")
    private String title;

    @Size(min = 3, message = "Login must be at least 3 characters")
    private String content;
    private Long id;

    private LocalDateTime created;
    private LocalDateTime modified;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void getCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
