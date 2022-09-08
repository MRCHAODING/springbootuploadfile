package com.atdc.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = {"/","/index.html"})
    public String index(){
        System.out.println("index");
        return "index";
    }
    @RequestMapping("/uploadfile")
        public String toupload(){
        return "uploadfile";
    }
}
