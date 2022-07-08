package com.project.pyg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

    @GetMapping(value = "cd")
    public String cd() {
        System.out.println("cd");
        return "cd";
    }
}
