package com.constructor.whichfirst;

/**
 * @author ng
 * @date 2019/11/14-14:37
 */
public class Demo {
    private int i = 9;

    public Demo() {
        setI();
    }
    public void setI(){
        i = 7;
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.i);
    }
}
