package com.project.pyg.service;

import com.project.pyg.dao.MemberDao;
import com.project.pyg.dto.SecurityMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return Optional.ofNullable(memberDao.getReferenceById(username)).filter(m -> m != null).map(m -> new SecurityMember(m).get());
        return memberDao.findById(username).filter(m -> m !=null).map(m -> new SecurityMember(m)).get();

    }
}
