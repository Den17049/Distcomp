package com.example.rest.service;

import com.example.rest.dto.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    NewsResponseTo create(NewsRequestTo news);

    NewsResponseTo update(@Valid NewsUpdate updatedNews);


    List<NewsResponseTo> findAll();
    Optional<NewsResponseTo> findById(Long id);

    void deleteById(Long id);


}
