package com.project.pyg.web;

import com.google.gson.Gson;
import com.project.pyg.dto.SoundDto;
import com.project.pyg.serviceImpl.SoundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SoundController {

    @Autowired
    private SoundServiceImpl soundService;

    @GetMapping(value = "/sound")
    public void moveSound(){
        System.out.println("sound");
    }

    @GetMapping(value = "/getSText")
    public void getSText(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int sl_id = Integer.parseInt((String) request.getParameter("sl_id"));

        SoundDto soundDto = soundService.getSText(sl_id);

        String sText = soundDto.getStext();
        Gson gson = new Gson();

        response.getWriter().print(gson.toJson(sText));
    }
}
