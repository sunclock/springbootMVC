package com.sunclock.book.springbootMVC.web.dto;

import com.sunclock.book.springbootMVC.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// NEVER USE ENTITY CLASS AS A REQUEST/RESPONSE CLASS!!!!
// SEPARATE ENTITY CLASS / DTO USED FOR CONTROLLER !!!!
// Entity class is a core class close to database.
// based on entity class, table is created, schema is changed.
// it's absurd to change entity class connected to table to change screen.. it is such a minor change to do so.
// countless service class, business logic works based on entity class.
// modification of entity class impacts a lot of classes.
// dto class for request and response is frequently changed as this dto class is for view!
// it's a best practice to separate role of View Layer and DB Layer.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
