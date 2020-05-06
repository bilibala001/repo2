package com.container.lists;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author ng
 * @date 2019/12/10-14:27
 */
public class TestNullWithHashMap {

    @Test
    public void fn1(){
        HashMap<String, String> map = new HashMap<>(10);
        map.put("aa","value1");
        map.put("cc",null);
        map.put("bb",null);
        map.put(null,"value3");
        System.out.println(map.size());
    }
}
