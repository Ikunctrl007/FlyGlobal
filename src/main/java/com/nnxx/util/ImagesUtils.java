package com.nnxx.util;

import java.io.File;

public class ImagesUtils {
    public static boolean deleteImage(String imagePath) {
        try {
            // 从 URL 中提取文件名
            String fileName = imagePath.replace("http://localhost:8080" + "/upload/", "");

            // 获取项目根目录的路径
            String projectDir = System.getProperty("user.dir");
            File uploadDir = new File(projectDir + "/upload");  // 上传目录路径

            // 构造文件对象
            File file = new File(uploadDir, fileName);

            // 检查文件是否存在并删除
            if (file.exists()) {
                return file.delete();  // 删除文件
            } else {
                return false;  // 文件不存在
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // 删除失败
        }
    }
}
