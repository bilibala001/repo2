package com.file;

import java.io.File;
import java.util.EmptyStackException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ng
 * @date 2019/11/24-11:49
 * 有的文件名会有一些广告性质的字符串，需要把它们都去掉看起来清爽。
 */
public class ChagFilenameRecursion {
    public static void main(String[] args) {
        String path = "E:\\vedio5\\十次方\\前端";
        String target = "【十次方禁广告闲聊讨论群863676367】";
        String replaceBy = "";
        File dir = new File(path);

        removeFilename(dir, target, replaceBy);
    }

    /**
     *
     * @param dir
     * @param target 要被替换的字符串
     * @param replaceBy 作为代替的字符串，这里是 ""
     */
    private static void removeFilename(File dir, String target, String replaceBy) {
        File[] files = dir.listFiles();
        Pattern pattern = Pattern.compile(target);
        for (File file : files) {
            // 测试发现，如果颠倒下面的if和 { }代码块的顺序，会出现一个bug，
            // 如果file是文件夹，这时候不知道为什么if(file.isDirectory) = false。
            //
            if (file.isDirectory()) {
                ChagFilenameRecursion.removeFilename(file, target, replaceBy);
            }
            {
                String parent = file.getParent();
                String oldname = file.getName();
                Matcher matcher = pattern.matcher(oldname);
                while (matcher.find()) {
                    String newname = matcher.replaceAll(replaceBy);
                    file.renameTo(new File(parent + "\\" + newname));
                }
            }
        }
    }
}
