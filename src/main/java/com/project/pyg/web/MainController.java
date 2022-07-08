package com.project.pyg.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@Slf4j
@Controller
public class MainController {

    @GetMapping({"","main"})
    public String moveMain(){
        System.out.println("main");
        return "main";
    }

    @PostMapping(value = "/fileupload")
    public @ResponseBody void getFile(@RequestParam("file1") MultipartFile multipartFile, HttpServletResponse response) {
        String url = null;

        try {

            String uploadpath = "C:/file/";
            String originFilename = multipartFile.getOriginalFilename();
            String extension = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
            long size = multipartFile.getSize();
            UUID uuid = UUID.randomUUID();
            String saveFileName = uuid.toString() + extension;

            if(!multipartFile.isEmpty()) {
                File file = new File(uploadpath, saveFileName);
                multipartFile.transferTo(file);

                // 사이즈 체크가 없다.
                response.getWriter().print("seccessed File upload");
            }

        } catch (Exception e) {
            log.info("Exception :" + e);
        }
    }
}
