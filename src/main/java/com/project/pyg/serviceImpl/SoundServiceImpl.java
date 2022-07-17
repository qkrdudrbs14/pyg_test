package com.project.pyg.serviceImpl;

import com.project.pyg.dao.SoundDao;
import com.project.pyg.dto.SoundDto;
import com.project.pyg.service.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoundServiceImpl implements SoundService {

    @Autowired
    private SoundDao soundDao;


    @Override
    public SoundDto getSText(int sl_id) {
        return soundDao.getReferenceById(sl_id);
    }
}
