package com.project.pyg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "main")
    public void moveMain(){
        System.out.println("main");
    }
}
