package com.example.rest.mapper;

import com.example.rest.dto.NewsRequestTo;
import com.example.rest.dto.NewsResponseTo;
import com.example.rest.entity.News;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-05T21:10:10+0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News toEntity(NewsRequestTo dto) {
        if ( dto == null ) {
            return null;
        }

        News news = new News();

        news.setId( dto.getId() );
        news.setEditorId( dto.getEditorId() );
        news.setTitle( dto.getTitle() );
        news.setContent( dto.getContent() );
        news.setCreated( dto.getCreated() );
        news.setModified( dto.getModified() );

        return news;
    }

    @Override
    public NewsResponseTo toResponse(News entity) {
        if ( entity == null ) {
            return null;
        }

        NewsResponseTo newsResponseTo = new NewsResponseTo();

        newsResponseTo.setId( entity.getId() );
        newsResponseTo.setEditorId( entity.getEditorId() );
        newsResponseTo.setTitle( entity.getTitle() );
        newsResponseTo.setContent( entity.getContent() );
        newsResponseTo.setModified( entity.getModified() );

        return newsResponseTo;
    }
}
