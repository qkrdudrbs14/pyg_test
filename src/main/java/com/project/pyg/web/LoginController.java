package com.project.pyg.web;

import com.google.gson.Gson;
import com.project.pyg.dto.MemberDto;
import com.project.pyg.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping({"login"})
    public String moveLogin() {
        System.out.println("login");
        return "login";
    }

    @GetMapping("/getLogin")
    public @ResponseBody void getLogin(HttpServletResponse response) throws IOException {

        List<MemberDto> getMemberList = loginService.getMemberList();

        Gson gson = new Gson();

        response.getWriter().print(gson.toJson(getMemberList));
    }
}
