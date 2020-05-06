package com.container.lists;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ng
 * @date 2019/12/10-14:25
 * 可以存储null值，是node.date =null,而node肯定不是null。
 */
public class TestNullWithArrayList {

    @Test
    public void fn1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add(null);
        list.add("bb");
        System.out.println(list.size());
    }
}
