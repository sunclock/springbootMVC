package com.sunclock.book.springbootMVC.web;

import com.sunclock.book.springbootMVC.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // this controller returns JSON
public class HelloController {

    @GetMapping("/hello") // create api handling http get request
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    } // @RequestParam? annotation to get param handed from api call
}
