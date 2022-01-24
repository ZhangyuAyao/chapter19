package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author: bytedance
 * @date: 2022/1/23
 * @description:
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)//根据路径构建一个File对象
    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent, String child)//根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public void create02() {
        File parentFile = new File("d:\\");//这里只是在内存里面创建了一个file对象
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();//只有在执行了 file.createNewFile 才会真正地在磁盘创建文件
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3 new File(String parent, String child) 根据父目录+子路径构建
    public void create03() {
        String parentPath = "d:\\";
        String fileName = "news3.txt";

        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


