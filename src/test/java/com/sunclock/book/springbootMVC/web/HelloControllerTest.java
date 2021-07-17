package com.sunclock.book.springbootMVC.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // connector between JUnit & springboot test
@WebMvcTest // with this annotation, you can use @Controller, @ContollerAdvice
            // but not @Service, @Component, @Repository
public class HelloControllerTest {

    @Autowired // inject Bean managed by spring
    private MockMvc mvc; // starting point of spring MVC test. with this class, you can do api test http get, post ect.

    @Test
    public void returns_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // request http get through MockMvc with address /hello
            .andExpect(status().isOk()) // validate result of mvc.perform/status of http header, 200 ok in this case.
                .andExpect(content().string(hello)); // validate content of request body.
    }

    @Test
    public void returns_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name) // param only accepts String value!
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                // .jsonpath is a method to validate json response value field by field.
                // it specifies field name based on $
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
