package com.file;

import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ng
 * @date 2019/11/10-9:26
 */
public class CharCount {
    @Test
    public void fn1() throws IOException {
//        "E:\temp\notepad\charNum.txt"
        String target = "con";
        int count = new CharCount().getCharCount(target, "E:\\temp\\notepad\\charNum.txt");
        System.out.println(target+"出现的次数为： "+count);
    }

    public int getCharCount(String target, String filePath) throws IOException {
        final Pattern pattern = Pattern.compile(target);
        File file = new File(filePath);
        int sum = 0;
        BufferedReader buffr = new BufferedReader(new FileReader(file));
        String s = null;

        while ((s = buffr.readLine()) != null) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                sum++;
            }
        }
        return sum;
    }

}
