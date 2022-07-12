package com.project.pyg.web;


import com.google.gson.Gson;
import com.project.pyg.dto.RestApiDto;
import com.project.pyg.serviceImpl.RestApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
@RequestMapping(value = "/restApi")
public class RestApiController {

    @Autowired
    private RestApiServiceImpl restApiService;

    @GetMapping(value = "/getRestDataList")
    public void getRestDataList(HttpServletResponse response) throws IOException {

        ArrayList<RestApiDto> getRestDataList = restApiService.getRestDataList();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(getRestDataList));
    }

    @GetMapping(value = "/getRestData/{user_id}")
    public void getRestData(@PathVariable("user_id") String userId, HttpServletResponse response) throws IOException {

        RestApiDto getRestData = restApiService.getRestData(userId);

        LinkedHashMap hm = new LinkedHashMap();
        hm.put("user_id",getRestData.getUser_id());
        hm.put("content1",getRestData.getContents1());
        hm.put("content2",getRestData.getContents2());
        hm.put("reg_dt",getRestData.getReg_dt());
        hm.put("upt_dt",getRestData.getUpt_dt());

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(hm));
    }

    @PostMapping(value = "/setRestData")
    public void setRestData(HttpServletRequest request, HttpServletResponse response)  throws IOException {

        String userId = request.getParameter("user_id");
        Double content1 = Double.parseDouble(String.valueOf(request.getParameter("content1")));
        Double content2 = Double.parseDouble(String.valueOf(request.getParameter("content2")));

        RestApiDto restApiDto = new RestApiDto();
        restApiDto.setUser_id(userId);
        restApiDto.setContents1(content1);
        restApiDto.setContents2(content2);

        int result = restApiService.setRestData(restApiDto);

        response.getWriter().print(result);
    }

    @PutMapping(value = "/inRestData/{user_id}/{content1}/{content2}")
    public void inRestData(@PathVariable("user_id") String userId,
                           @PathVariable("content1") Double content1,
                           @PathVariable("content2") Double content2,
                           HttpServletResponse response) throws IOException {

        RestApiDto restApiDto = new RestApiDto();
        restApiDto.setUser_id(userId);
        restApiDto.setContents1(content1);
        restApiDto.setContents2(content2);

        int result = restApiService.inRestData(restApiDto);
        response.getWriter().print(result);
    }
}
