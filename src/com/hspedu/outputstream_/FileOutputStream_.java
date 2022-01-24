package com.hspedu.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileOutputStream_ {

    //创建 FileOutPutStream对象
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        String filePath = "d:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //老师说明
            //1. new FileOutPutStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutPutStream(filePath, true)创建方式，当写入内容时，会追加到文件后面
            //得到 FileOutPutStream对象
            fileOutputStream = new FileOutputStream(filePath, true);
            //1. 写入一个字节
            //fileOutputStream.write('H'); //char可以自动转成int
            //2. 写入字符串
            String str =  "hello, world!";
            //fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(), 0, str.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
