package com.ericsson.owa.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    //Test in Postman GET localhost:8080/api/hello
    @GetMapping("/hello")
    public String test(){
        return "Hello World";
    }

    //Test in Postman GET localhost:8080/api/html
    @GetMapping("/html")
    public String testHtml(){
        return "<h1>Hello World<h1>";
    }
}