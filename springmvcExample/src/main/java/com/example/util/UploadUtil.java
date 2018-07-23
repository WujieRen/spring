package com.example.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by renwujie on 2018/06/28 at 17:15
 */
public class UploadUtil {
    /**
     * 解析上传的压缩文件
     *
     * @param request 请求
     * @param file    上传文件
     * @return
     * @throws Exception
     */
    public static String resolveCompressUploadFile(HttpServletRequest request, MultipartFile file, String path) throws Exception {

                  /* 截取后缀名 */
        if (file.isEmpty()) {
            throw new Exception("文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        int pos = fileName.lastIndexOf(".");
        String extName = fileName.substring(pos + 1).toLowerCase();
        //判断上传文件必须是zip或者是rar否则不允许上传
        if (!extName.equals("zip") && !extName.equals("rar")) {
            throw new Exception("上传文件格式错误，请重新上传");
        }
        // 时间加后缀名保存
        String saveName = UUID.randomUUID() + "." + extName;
        //文件名
        String saveFileName = saveName.substring(0, saveName.lastIndexOf("."));
        // 根据服务器的文件保存地址和原文件名创建目录文件全路径
        File pushFile = new File(path + "/" + saveFileName + "/" + saveName);

        File descFile = new File(path + "/" + saveFileName);
        if (!descFile.exists()) {
            descFile.mkdirs();
        }
        //解压目的文件
        String descDir = path + "/" + saveFileName + "/";

        file.transferTo(pushFile);

        //开始解压zip
        if (extName.equals("zip")) {
            CompressFileUtils.unZipFiles(pushFile, descDir);
        } else if (extName.equals("rar")) {
            //开始解压rar
            CompressFileUtils.unRarFile(pushFile.getAbsolutePath(), descDir);
        } else {
            throw new Exception("文件格式不正确不能解压");
        }
        //遍历文件夹
        boolean isExist = checkIndexHtml(descDir);
        if (!isExist) {
            throw new Exception("文件中缺少index.html");
        }
        return saveFileName;
    }

    /**
     * 检查是否有index.html
     *
     * @param strPath
     * @return
     */
    public static boolean checkIndexHtml(String strPath) {
        boolean flag = false;
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if ("index.html".equals(fileName)) { // 判断是否有index.html
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

}
