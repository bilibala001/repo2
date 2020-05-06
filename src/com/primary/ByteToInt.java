package com.primary;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @author ng
 * @date 2019/12/10-18:01
 */
public class ByteToInt {

    /**
     * byte转为int，byte转为long
     */
    @Test
    public void fn4() {
        byte b = (byte) 0X8D;
        int v = b & 0xFF; // 是数字0，不是字母o,0的中间有条线
        long l1 = b & 0XFFFFFFFF;
        System.out.println(Long.toBinaryString(l1));
    }

    // 怎么分辨一个byte是正数还是负数
    // 二位16进制，高位>=8,就是一个负数了。
    @Test
    public void fn3() {
        // 那byte存储16进制的93是多少。16*5 +D =5D
        byte b = (byte) 0X5D;   // 0101 1101    8位bit的最高位是0
        System.out.println(b + "二进制表示为" + Integer.toBinaryString((int) b));
        // byte存储 - 93是多少？
        byte c = (byte) 0XA3;   // 1010 0011    8位bit的最高位是1
        System.out.println(c + "二进制表示为" + Integer.toBinaryString((int) c));

        byte d = (byte) 0X83;   // 1000 0011    93,最高位是1，应该是一个负数
        System.out.println(d + "二进制表示为" + Integer.toBinaryString((int) d));

    }

    @Test
    public void fn2() {
        byte[] bytes = new byte[1024];
        // -93
        bytes[0] = (byte) 0xA3;
        int i = bytes[0];
        i = 0XA3;
        System.out.println("bytes[0] = " + bytes[0]);
        System.out.println("int i = " + i + "\t;93 = " + Integer.toBinaryString(93));
    }

    /**
     * 一个127~-128的值
     * 直接把一个byte值赋值给int，得到a
     * 同样的byte值直接输出，得到b
     * 结果a!=b
     *
     * 0x80是无符号的128
     * 不相等不奇怪，可是
     */
    @Test
    public void fn1() {
//        0xA3 =163  0x7f == 127
        byte b =  (byte) 0x81;
        int i = 0X81;
        System.out.println(i + "\t" + Integer.toBinaryString(i));
        System.out.println(b + "\t" + Integer.toBinaryString(b));

        int j = 2;
        byte k = (byte)0X2;
        System.out.println(j==k); // true
    }
}
