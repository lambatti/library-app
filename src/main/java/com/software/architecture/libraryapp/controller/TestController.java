package com.software.architecture.libraryapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "Hello, World!";
    }
}
