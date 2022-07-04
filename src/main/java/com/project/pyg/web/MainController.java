package com.project.pyg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"","main"})
    public String moveMain(){
        System.out.println("main");
        return "main";
    }
}
