package com.project.pyg.web;


import com.google.gson.Gson;
import com.project.pyg.dto.RestApiDto;
import com.project.pyg.serviceImpl.RestApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
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
}
