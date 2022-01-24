package com.hspedu.outputstream_;

import java.io.*;

/**
 * @author: bytedance
 * @date: 2022/1/24
 * @description:
 *
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "d:\\202110140827.mp4";
        String destFilePath = "d:\\copy202110140827.mp4";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //因为 FileInputStream 是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;

            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流 关闭外层处理流即可，底层会去关闭节点流
            try {
                if (bis != null) {
                    bis.close();
                }
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
