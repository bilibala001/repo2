package com.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ng
 * @date 2019/11/7-15:46
 */
public class RegexWork {
    public static void main(String[] args) {
        String s = "hello , where you going";
         System.out.println("***rrrr"+1 + "***");
        // groupAnaly(s);

        String s2 = "aabbceeefgggggggggg";
        String regex = "(.)\\1*";  //.+?
        convertStr(s2, regex);
    }

    /**
     * 把aabbbcdeeee 转为a2b3cde4这样的格式。
     * 正则表达式：(.)\1*
     * \1表示在正则表达式中引用 第一组。  \\1
     * $1表示在正则表达式外引用 第一组。  "$1" matcher.replaceAll("$1"); 去重
     *
     * @param s2
     * @param regex
     */
    private static void convertStr(String s2, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(s2);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String str = matcher.group();
            if (str.length() == 1) {
                sb.append(str.charAt(0));
            } else {
                sb.append(str.charAt(0)).append(str.length());
            }
        }
        System.out.println(sb);
    }

    /**
     * "hello , where you going"
     * 测试 去掉（(＼\s+)）的结果：包含going.说明了实际匹配过程中，
     * 先匹配的是(\S+)(\s+) , 再截取(\S+)的部分，而不是匹配的(\S+)。
     * 可以看过只有一个Regex表达式，就是\S+\s+。
     * 即：先匹配，再截取。
     *
     * @param s
     */
    private static void groupAnaly(String s) {
        String reg = "(\\S+)(\\s+)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.print(matcher.group(1));}
    }
    @Test
    public void fn1(){
        groupAnaly("hello , where you going");
    }
}
