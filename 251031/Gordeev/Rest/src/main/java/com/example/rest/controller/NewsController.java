package com.example.rest.controller;

import com.example.rest.dto.*;
import com.example.rest.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/v1.0/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<NewsResponseTo> create(@Valid @RequestBody NewsRequestTo news) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.create(news));
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseTo>> findAll() {
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponseTo> findById(@PathVariable Long id) {
        return newsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<NewsResponseTo> updateNews(@PathVariable Long id, @RequestBody NewsUpdate dto) {
        dto.setId(id);  // Добавляем id из URL в тело запроса
        NewsResponseTo response = newsService.update(dto);
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<NewsResponseTo> updateNewsWithoutPathId(@Valid @RequestBody NewsUpdate dto) {
        NewsResponseTo response = newsService.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        newsService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editor not found")); // должен выбрасываться
        newsService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
