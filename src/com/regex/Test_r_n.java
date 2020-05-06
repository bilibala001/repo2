package com.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ng
 * @date 2019/12/9-14:58
 */
public class Test_r_n {
    @Test
    public void fn1(){
        System.out.println("ww3\r123u99");
    }
    @Test
    public void fn2(){
        String str = "3\n123u99";
        String reg = ".\n.";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find())
            System.out.print(matcher.group());
    }
}
