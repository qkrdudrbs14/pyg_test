package com.project.pyg.serviceImpl;

import com.project.pyg.dao.MemberDao;
import com.project.pyg.dto.MemberDto;
import com.project.pyg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<MemberDto> getMemberList() {
        return memberDao.findAll();
    }

    @Override
    public MemberDto getMember(String userid) {
        return memberDao.getReferenceById(userid);
    }
}
