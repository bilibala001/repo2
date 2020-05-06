package com.container.map;

/**
 * @author ng
 * @date 2019/12/22-20:16
 */
public class Phone {
    private String name;
    String color;

    @Override
    public String toString() {
        // 转为json和toString没有关系
        return name+"--"+color;
    }

    public Phone(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
