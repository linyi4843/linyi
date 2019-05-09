package com.manguo.fun.linyi.ly.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * @auther linyi
 * @email linyi4843@gmail.com
 */
public class ZipUtils {
    //压缩图片
    public static void main(String[] args) throws IOException {
        Thumbnails.of("原文件地址")
                .scale(1f)
                .outputQuality(0.5f)
                .toFile("压缩后地址");
    }
}
