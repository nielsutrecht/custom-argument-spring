package com.nibado.example.customargumentspring.controller;

import com.nibado.example.customargumentspring.component.UserContext;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/example")
    public ExampleResponse example(final UserContext context) {
        return new ExampleResponse(String.format("Hello user %s from ip %s", context.getId(), context.getIp()));
    }

    @Value
    public static class ExampleResponse {
        private String message;
    }
}
