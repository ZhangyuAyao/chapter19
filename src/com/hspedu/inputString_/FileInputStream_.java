package com.hspedu.inputString_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 使用read()读取一个字节
     */
    @Test
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕
            try {
                while ((readData = fileInputStream.read()) != -1) {
                    System.out.print((char)readData);//转成char显示
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭文件流，释放资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用read(byte[] b)读取文件、提高读取效率
     */
    @Test
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        int readData = 0;
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕
            try {
                while ((readLen = fileInputStream.read(buf)) != -1) {
                    System.out.print(new String(buf, 0, readLen));//显示
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭文件流，释放资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //OutputStream
}
