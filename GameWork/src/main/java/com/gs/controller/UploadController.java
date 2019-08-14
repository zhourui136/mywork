package com.gs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-5 上午10:26
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile file, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        File dir = new File(realPath);
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        String filename = file.getOriginalFilename();
        File serverFile = new File(dir, filename);
        log.info("file文件真实路径：" + serverFile.getAbsolutePath());
        try {
            file.transferTo(serverFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + filename;
            return filePath;
        } catch (Exception e) {
            log.error("上传文件异常:" + e);
            e.printStackTrace();
        }
        return "上传失败";
    }
}
