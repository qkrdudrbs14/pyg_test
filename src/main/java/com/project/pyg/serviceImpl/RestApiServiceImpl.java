package com.project.pyg.serviceImpl;

import com.project.pyg.dao.RestApiDao;
import com.project.pyg.dto.RestApiDto;
import com.project.pyg.service.RestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RestApiServiceImpl implements RestApiService {

    @Autowired
    private RestApiDao restApiDao;
    
    @Override
    public ArrayList<RestApiDto> getRestDataList() {
        return (ArrayList<RestApiDto>) restApiDao.findAll();
    }

    @Override
    public RestApiDto getRestData(String userId) {
        return restApiDao.getReferenceById(userId);
    }
}
