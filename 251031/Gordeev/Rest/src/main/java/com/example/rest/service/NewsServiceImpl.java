package com.example.rest.service;

import com.example.rest.dto.NewsRequestTo;
import com.example.rest.dto.NewsResponseTo;
import com.example.rest.dto.NewsUpdate;
import com.example.rest.entity.News;
import com.example.rest.mapper.NewsMapper;
import com.example.rest.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class NewsServiceImpl implements NewsService {


    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }
    @Override
    public NewsResponseTo create(NewsRequestTo newsRequestTo) {
        News news = newsMapper.toEntity(newsRequestTo);
        news.setCreated(LocalDateTime.now());
        news.setModified(LocalDateTime.now());
        News saved = newsRepository.create(news);
        return newsMapper.toResponse(saved);
    }

    @Override
    public NewsResponseTo update(NewsUpdate updatedNews) {
        News existing = newsRepository.findById(updatedNews.getId())
                .orElseThrow(() -> new RuntimeException("News not found with id " + updatedNews.getId()));

        if (updatedNews.getTitle() != null) {
            existing.setTitle(updatedNews.getTitle());
        }
        if (updatedNews.getContent() != null) {
            existing.setContent(updatedNews.getContent());
        }

        existing.setModified(LocalDateTime.now());

        News updated = newsRepository.update(existing);
        return newsMapper.toResponse(updated);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public List<NewsResponseTo> findAll() {
        return newsRepository.findAll()
                .stream()
                .map(newsMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<NewsResponseTo> findById(Long id) {
        return newsRepository.findById(id)
                .map(newsMapper::toResponse);
    }
}
