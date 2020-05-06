package com.container.lists;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ng
 * @date 2019/12/23-10:06
 */
public class TestGet {
    @Test
    // 非空对象不能转为boolean,会类型转换错误。
    public void fn1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("add");
        list.add("wwo");
        String s = list.get(1);
        boolean b;
        /*if ((boolean) s) b = true;
        else b = false;
        System.out.println(b);*/
    }
}
