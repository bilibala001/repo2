package com.clazz;

import org.junit.Test;

import java.lang.reflect.Type;

/**
 * @author ng
 * @date 2019/11/12-13:17
 */
public class ClassMethodDemo {
    /**
     * 该clazz对象的父类类型, class对象
     * @throws ClassNotFoundException
     */
    @Test
    public void fn2() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.constructor.newincon.Person");
        Type type = clazz.getGenericSuperclass();
        System.out.println(type.getTypeName());
    }


    /**
     * clazz.getGenericInterfaces()返回该clazz implements的所有接口。
     * Type是所有接口的父类。{int,String ,float,void ,[],<>}
     */
    @Test
    public void fn1() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.constructor.newincon.Person");
        Type[] interfaces = clazz.getGenericInterfaces();
        for (Type anInterface : interfaces) {
            System.out.println(anInterface.getTypeName());
        }

    }
}
