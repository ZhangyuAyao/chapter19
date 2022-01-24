package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    //获取文件的信息
    public void info() {
        //先创建文件对象
        File file = new File("d:\\news1.txt");

        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());

        //绝对路径
        System.out.println("文件名字=" + file.getAbsolutePath());

        //文件父级目录
        System.out.println("文件父级目录" + file.getParent());

        //文件大小（字节）
        System.out.println("文件大小（字节）" + file.length());

        //文件是否存在
        System.out.println("文件是否存在" + file.exists());

        System.out.println("是不是一个文件" + file.isFile());

        System.out.println("是不是一个目录" + file.isDirectory());

    }
}
