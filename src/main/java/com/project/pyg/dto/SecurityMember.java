package com.project.pyg.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class SecurityMember extends User {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final long serialVersionUID = 1L;

    public SecurityMember(MemberDto memberDto) {
//        super(memberDto.getUserid(), memberDto.getPassword(), makeGrantedAuthority(memberDto.getRole()));
        super(memberDto.getUser_id(), memberDto.getPassword(), Arrays.asList(new SimpleGrantedAuthority(ROLE_PREFIX + memberDto.getRole())));
    }

    /*
    private static List<GrantedAuthority> makeGrantedAuthority(String role){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        return list;
    }
     */
}
