package com.msh.springboot.controller;

import com.msh.springboot.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
public class UploadController {
    @GetMapping("/upload.html")
    public String uploadPage(){
        return "upload";
    }//視圖解析，轉發到templates/upload.html,因為thymeleaf

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("header") MultipartFile header, @RequestParam("datas") MultipartFile[] datas) throws IOException {
        //拿到動態的類路徑
        String path = ResourceUtils.getURL("classpath:").getPath();
        //按日期創建目錄
        File file = new File(path + WebUtils.getUploadFileDirectory());

        if (!file.exists()){
            file.mkdirs();
        }
        if (!header.isEmpty()){
            String originalFilename = header.getOriginalFilename();
            //隨機數+電腦當前時間+文件名(防止文件名相同)
            String fileName = UUID.randomUUID().toString()+"_"+System.currentTimeMillis()+originalFilename;
            log.info("保存文件的絕對路徑=" + file.getAbsolutePath());
            header.transferTo(new File(file.getAbsolutePath()+"/"+fileName));
        }
        if (datas.length>0){
            for (MultipartFile data:datas){
                if (!data.isEmpty()){
                    String originalFilename = data.getOriginalFilename();
                    String fileName = UUID.randomUUID().toString()+"_"+System.currentTimeMillis()+originalFilename;
                    data.transferTo(new File(file.getAbsolutePath()+"/"+fileName));
                }
            }
        }
        return "上傳成功";
    }
}
