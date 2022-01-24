package com.hspedu.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileReader_ {
    public static void main(String[] args) {


    }

    //单个字符读取
    @Test
    public void readFile01() {
        String filePath = "d:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read，单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字符数组读取
     */
    @Test
    public void readFile02() {
        String filePath = "d:\\story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];

        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf)，返回的是实际读取到的字符数
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
