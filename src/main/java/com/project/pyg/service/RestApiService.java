package com.project.pyg.service;

import com.project.pyg.dto.RestApiDto;

import java.util.ArrayList;

public interface RestApiService {

    public ArrayList<RestApiDto> getRestDataList();

    public RestApiDto getRestData(String user_id);

    public int setRestData(RestApiDto restApiDto);

    public int inRestData(RestApiDto restApiDto);
}
