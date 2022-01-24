package com.hspedu.writer_;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "d:\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
            fileWriter.write('H');
            fileWriter.write(chars);
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
            fileWriter.write(" 你好北京~");
            fileWriter.write("上海天津", 0, 2);
            fileWriter.write("风雨之后，定见彩虹~");
            //如果数据量多的话也可以使用循环操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
