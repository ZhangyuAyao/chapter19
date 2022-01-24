package com.hspedu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception{
        String filePath = "d:\\FileReader_.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();

    }
}
