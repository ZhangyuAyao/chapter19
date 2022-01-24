package com.hspedu.writer_;

import java.io.*;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 */
public class BufferedCopy_ {
    public static void main(String[] args) {

//        String srcFilePath = "d:\\a.java";
//        String destFilePath = "d:\\a2.java";
        String srcFilePath = "d:\\cat2.jpg";
        String destFilePath = "d:\\a2.jpg";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));


            //说明：readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
