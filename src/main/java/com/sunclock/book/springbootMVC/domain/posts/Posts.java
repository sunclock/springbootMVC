package com.sunclock.book.springbootMVC.domain.posts;


import com.sunclock.book.springbootMVC.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// NEVER CREATE SETTER METHOD IN ENTITY CLASS!!!!!!!
// instead, use method defining its purpose clearly if change of value is needed
@Getter // lombok simplifies code but not a necessary annotation.
@NoArgsConstructor // add default constructor. same effect as 'public Posts() {}'
@Entity // JPA annotation. necessary! locate close to class.
    // this class will be linked with table! it is called Entity class.
    // by default, it matches camelCase name of classes into under_score named table
public class Posts extends BaseTimeEntity {

    @Id // pk field of table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment!
    private Long id; // set pk of entity as auto_increment long type! it is recommended

    @Column(length = 500, nullable = false) // only when customizing options. not necessary.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; // See! there's no @Column annotation here.

    @Builder // create builder pattern class of this class.
        // when declared above constructor, only includes fields included in that constructor
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
