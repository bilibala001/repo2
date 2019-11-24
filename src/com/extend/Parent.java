package com.extend;

/**
 * @author ng
 * @date 2019/11/12-16:23
 */
public class Parent {
    protected String name = "par";

    public Parent(String name) {
        this.name = name;
    }

    public Parent() {
        System.out.println("parent constructor!!");
    }
    public void print(){
        System.out.println("父类的print 方法:"+this);
    }
    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }
}
