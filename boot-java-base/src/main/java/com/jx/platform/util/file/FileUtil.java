package com.jx.platform.util.file;

public class FileUtil {

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


}
