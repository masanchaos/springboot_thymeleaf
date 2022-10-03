package com.msh.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebUtils {
    //文件上傳目標路徑
    public static String UPLOAD_FILE_DIRECTORY = "static/images/upload/";
    public static String getUploadFileDirectory(){
        //路徑後加上日期(分日期存放)
        return UPLOAD_FILE_DIRECTORY + new SimpleDateFormat("yyyy/MM/dd").format(new Date());

    }
}
