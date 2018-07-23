package com.example.controller;

import com.example.util.UnComprassFileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by renwujie on 2018/06/28 at 16:43
 */
@Controller
public class UploadFile {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadPushContent(MultipartFile pushContent, HttpSession session, HttpServletRequest request) {
            //获取存储文件的目录
            String path = session.getServletContext().getRealPath("/upload");
           /* try {
                String saveFileName = UploadUtil.resolveCompressUploadFile(request, pushContent, path);
                String url = "/" + saveFileName + "/" + "index.html";
                System.out.println("urlFile" + url);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
           File file = new File(path);
        try {
            FileUtils.copyInputStreamToFile(pushContent.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UnComprassFileUtil.unZipFiles(file, path);

    }
}
