package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    //判断 d:\\news1.txt 是否存在，如果存在就删除
    @Test
    public void m1() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        if(file.exists()) {
            if(file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在");
        }
    }

    //判断 D:\demo02是否存在，存在就删除，否则提示不存在
    //这里我们需要体会到，在java编程中，目录也被当做文件
    @Test
    public void m2() {
        String filePath = "D:\\demo02";
        File file = new File(filePath);
        if(file.exists()) {
            if(file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在");
        }
    }

    //判断 D:\demo02\a\b\c是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {
        String directoryPath = "D:\\demo02\\a";
        File file = new File(directoryPath);
        if(file.exists()) {
            System.out.println(directoryPath + "该目录已经存在");
        } else {
            if (file.mkdir()) {//创建一级目录使用mkdir()， 创建多级目录使用mkdirs()
                System.out.println(directoryPath + "创建成功...");
            } else {
                System.out.println(directoryPath + "创建失败...");
            }
            System.out.println("该目录不存在");
        }
    }

    //OutputStream
    //InputStream

}
