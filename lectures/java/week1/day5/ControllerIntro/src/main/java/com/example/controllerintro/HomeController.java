package com.example.controllerintro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
    public String hello() {
            return "Hello World!";
    }
	@RequestMapping("/hey")
    public String hey() {
            return "What happening!";
    }
}
