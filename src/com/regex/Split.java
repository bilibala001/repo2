package com.regex;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ng
 * @date 2019/12/9-18:53
 */
public class Split {
    String s = ",,ab,,c,va,,,";

    // 用Guava
    @Test
    public void fn4() {

    }

    @Test
    public void fn3() {
         System.out.println("***bbbb"+2 + "***");
        String str = ",a,,b,";
    }

    /**
     * 开头的空字符不去除，结尾的空字符去除。
     * 结尾的不想去除，就用s.split(reg,-1)
     * ",,ab,,c,va,,,," length = 6
     * ",,,ab,,c,va,,," length=7
     * ",,ab,,c,va,,,"length=6
     */
    @Test
    public void fn2() {
        String reg = ",";
//        String[] arr = s.split(reg,-1);
//        String[] arr = s.split(reg, 3);
        String  s = ",,ab,,c,va,,,";
        String[] arr = s.split(reg);
        System.out.println(arr.length);
       /* for (String s1 : arr) {
            System.out.println("***"+s1 + "***");
        }*/
        System.out.println(Arrays.toString(arr));
    }

    // 结论：用空字符串分割，会分开每个字符
    @Test
    public void fn1() {
        String reg = "";
//        String reg = "aa";
        String[] arr = s.split(reg, -1);
        for (String s1 : arr) {
            if (s1 == arr[0]) {
                System.out.print("[" + arr[0] + ",");
                continue;
            }
            if (s1 == arr[arr.length - 1]) {
                System.out.print(arr[arr.length - 1] + "]");
                continue;
            }
            System.out.print(s1 + ",");
        }
    }
}
