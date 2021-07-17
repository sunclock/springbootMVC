package com.sunclock.book.springbootMVC.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //when JPA Entity classes inherits BaseTimeEntity, its fields is perceived as columns too
@EntityListeners(AuditingEntityListener.class) // add Auditing function to BaseTimeEntity class
public class BaseTimeEntity {

    @CreatedDate // when Entity is created and stored, date is stored automatically
    private LocalDateTime createdDate;

    @LastModifiedDate // when Entity is modified, date is stored automatically
    private LocalDateTime modifiedDate;

}
