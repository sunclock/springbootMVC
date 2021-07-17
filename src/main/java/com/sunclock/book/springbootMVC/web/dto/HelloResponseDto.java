package com.sunclock.book.springbootMVC.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // create get method of all defined fields
@RequiredArgsConstructor // create constructor including all defined final fields
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
