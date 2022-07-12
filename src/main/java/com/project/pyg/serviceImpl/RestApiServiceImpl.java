package com.project.pyg.serviceImpl;

import com.project.pyg.dao.RestApiDao;
import com.project.pyg.dto.RestApiDto;
import com.project.pyg.service.RestApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

@Slf4j
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

    @Override
    public int setRestData(RestApiDto restApiDto) {

        int result = 0;
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            restApiDto.setReg_dt(timestamp);
            restApiDao.save(restApiDto);
            result = 1;
        } catch(Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int inRestData(RestApiDto restApiDto){

        int result = 0;
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            restApiDto.setUpt_dt(timestamp);
            restApiDao.save(restApiDto);
            result = 1;
        } catch(Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
