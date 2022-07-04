package com.project.pyg.service;

import com.project.pyg.dto.MemberDto;
import java.util.List;

public interface LoginService {
    public List<MemberDto> getMemberList();
    public MemberDto getMember(String userid);
}
