package com.hspedu.outputstream_;

import com.hspedu.inputString_.FileInputStream_;

import java.io.*;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝，将 d:\\cat.jpg 拷贝到 c:\\
        //思路分析
        //1. 创建文件的输入流，将文件读入到程序
        //2. 创建文件的输出流，将读取到的文件数据，写入到指定的文件

        String srcFilePath = "d:\\cat.jpg";
        String desFilePath = "d:\\cat2.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(desFilePath);
            //定义一个字节数组，提高读取效果
            byte[] buf = new byte[1024];
            int readLen = 0;
            while((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf);
            }

            System.out.println("拷贝ok~");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //Writer
}
