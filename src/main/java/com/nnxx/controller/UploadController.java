package com.nnxx.controller;

import com.nnxx.domain.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    // 文件存储路径，设置为项目根目录下的 upload 文件夹
    private static final String UPLOAD_DIR = "upload/";

    @Value("${server.port}")
    private String serverPort;

    /**
     * 上传头像接口
     *
     * @param file MultipartFile
     * @return 上传结果
     */
    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new Result(400, "上传失败，文件为空！");
        }

        // 获取项目根目录的路径
        String projectDir = System.getProperty("user.dir");
        File uploadDir = new File(projectDir + "/upload");  // 确保上传路径在项目根目录下

        // 确保上传目录存在
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // 如果目录不存在，创建目录
        }

        // 获取文件的原始名称
        String originalFilename = file.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "_" + originalFilename;

        // 保存文件到 upload 目录下
        File destFile = new File(uploadDir, newFileName);
        try {
            file.transferTo(destFile);  // 将文件保存到指定路径

            // 拼接文件访问的 URL
            String fileUrl = "http://localhost:" + serverPort + "/upload/" + newFileName;

            return new Result(200, "上传成功！", fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(500, "上传失败，服务器错误！");
        }
    }
    @PostMapping("/passport")
    public Result uploadPassport(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new Result(400, "上传失败，文件为空！");
        }

        // 获取项目根目录的路径
        String projectDir = System.getProperty("user.dir");
        File uploadDir = new File(projectDir + "/upload");  // 确保上传路径在项目根目录下

        // 确保上传目录存在
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // 如果目录不存在，创建目录
        }

        // 获取文件的原始名称
        String originalFilename = file.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "_" + originalFilename;

        // 保存文件到 upload 目录下
        File destFile = new File(uploadDir, newFileName);
        try {
            file.transferTo(destFile);  // 将文件保存到指定路径

            // 拼接文件访问的 URL
            String fileUrl = "http://localhost:" + serverPort + "/upload/" + newFileName;

            return new Result(200, "上传成功！", fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(500, "上传失败，服务器错误！");
        }
    }

}
