package com.example.rest.repository;

import com.example.rest.entity.News;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class NewsRepositoryImpl implements NewsRepository {

    private final Map<Long, News> newsMap = new HashMap<>();
    private long nextId = 1L;

    @Override
    public News create(News news) {
        news.setId(nextId++);
        news.setCreated(LocalDateTime.now());
        news.setModified(LocalDateTime.now());
        newsMap.put(news.getId(), news);
        return news;
    }

    @Override
    public News update(News news) {
        if (!newsMap.containsKey(news.getId())) {
            throw new IllegalArgumentException("News with ID " + news.getId() + " not found");
        }
        news.setModified(LocalDateTime.now());
        newsMap.put(news.getId(), news);
        return news;
    }

    @Override
    public void deleteById(Long id) {
        newsMap.remove(id);
    }

    @Override
    public List<News> findAll() {
        return new ArrayList<>(newsMap.values());
    }

    @Override
    public Optional<News> findById(Long id) {
        return Optional.ofNullable(newsMap.get(id));
    }
}
