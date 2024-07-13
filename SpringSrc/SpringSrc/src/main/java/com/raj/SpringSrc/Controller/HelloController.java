package com.raj.SpringSrc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest req){

        return("Hello");
    }

    @GetMapping("/about")
    public String about(){
        return("Raj Yadav");
    }
}
