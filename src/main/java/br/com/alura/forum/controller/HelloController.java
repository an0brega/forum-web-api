package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{

    @RequestMapping ("/") //Will be recalled on the main page localhost
    @ResponseBody // Says that this method is not actually a page, but a method. Instead of search for a page the browser
    // will just receive the return value of this method
    public String Hello(){
        return "Hello World!";
    }
}