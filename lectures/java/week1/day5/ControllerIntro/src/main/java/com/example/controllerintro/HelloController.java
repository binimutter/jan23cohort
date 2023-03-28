package com.example.controllerintro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juli")
public class HelloController {

	@RequestMapping("")
    public String juli() {
            return "Hello Juli!";
    }
	@RequestMapping("/oliver")
    public String oliver() {
            return "Hello Oliver!";
    }
}
