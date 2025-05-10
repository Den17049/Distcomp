package com.example.rest.mapper;

import com.example.rest.dto.NewsRequestTo;
import com.example.rest.dto.NewsResponseTo;
import com.example.rest.entity.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    News toEntity(NewsRequestTo dto);
    NewsResponseTo toResponse(News entity);
}