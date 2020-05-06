package com.container.map;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author ng
 * @date 2019/12/22-20:16
 */
public class ToJson {
    public static void main(String[] args) {
        HashMap<String, Phone> map = new HashMap<>();
        map.put("p1",new Phone("ph1","white"));
        map.put("p2",new Phone("ph2","yellow"));
        map.put("p3",new Phone("ph3","red"));

        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);
    }
}
