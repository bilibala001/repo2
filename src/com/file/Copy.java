package com.file;

import org.junit.Test;

import java.io.*;

/**
 * @author ng
 * @date 2019/11/11-10:02
 */
public class Copy {
    @Test
    public void fn1() throws IOException {
        copy("F:\\Music\\蔡依林\\蔡依林(Jolin Tsai) - 城堡(甜蜜庆功版)\\10 倒帶 (Rewind).m4a","E:\\temp\\a.m4a");
    }

    public static void copy(String source,String destination) throws IOException {
         System.out.println("不用看这行代码");
        File file = new File(source);
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
        byte[] rarr = new byte[1024];
        int len = -1;
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(destination));
        while ((len = br.read(rarr))!=-1){
            os.write(rarr,0,len);
        }
        os.close();br.close();
    }
}
