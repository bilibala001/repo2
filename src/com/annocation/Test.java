package com.annocation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ng
 * @date 2019/12/5-19:06
 * 虚拟机启动参数设置：-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
 * 可以生成动态代理的class文件。在项目根目录
 */
public class Test {
    @FirstAnnocation
    private String name="name1";

    @FirstAnnocation
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<Test> clazz = Test.class;
        /*Method method = clazz.getMethod("main", String[].class);
        FirstAnnocation annotation = method.getAnnotation(FirstAnnocation.class);
        System.out.println(annotation);*/
        Field field = clazz.getDeclaredField("name");
        Annotation anno1 = field.getAnnotation(FirstAnnocation.class);
        System.out.println(anno1);

    }
}
