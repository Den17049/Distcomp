package com.example.rest.mapper;

import com.example.rest.dto.TagRequestTo;
import com.example.rest.dto.TagResponseTo;
import com.example.rest.entity.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-05T21:10:10+0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toEntity(TagRequestTo tagRequestTo) {
        if ( tagRequestTo == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setName( tagRequestTo.getName() );

        return tag;
    }

    @Override
    public TagResponseTo toResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponseTo tagResponseTo = new TagResponseTo();

        tagResponseTo.setId( tag.getId() );
        tagResponseTo.setName( tag.getName() );

        return tagResponseTo;
    }
}
