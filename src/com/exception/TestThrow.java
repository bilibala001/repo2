package com.exception;

import java.io.IOException;

/**
 * @author ng
 * @date 2019/12/7-10:53
 */
public class TestThrow {
    public static void main(String[] args) throws IOException {
        String s=null;
        TestThrow testThrow = new TestThrow();
        try {
            s = testThrow.fn1();
        } catch (IOException e) {
            System.out.println("出异常了");
        }
        s = "aaa";
        System.out.println(s);


    }

    // 测试一下，一个有返回值的方法，能否只抛异常，且没有返回值
    public String fn1() throws IOException {
        throw new IOException("io异常了");
    }
}
