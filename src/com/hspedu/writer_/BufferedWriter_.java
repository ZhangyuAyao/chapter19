package com.hspedu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\ok.txt";
        //创建BufferedWriter
        //1. new FileWriter(filePath, true)表示以追加的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.write("hello1, 韩顺平教育");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2, 韩顺平教育");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello3, 韩顺平教育");
        //插入一个换行

        //说明：关闭外层流即可，传入的 new
        bufferedWriter.close();
    }
}
