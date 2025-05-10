package com.example.rest.repository;

import com.example.rest.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    News create(News news);
    News update(News news);
    void deleteById(Long id);
    List<News> findAll();
    Optional<News> findById(Long id);
}
