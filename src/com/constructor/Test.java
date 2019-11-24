package com.constructor;

/**
 * @author ng
 * @date 2019/11/14-15:48
 */
class Super {
    Super() { printThree(); }
    void printThree() { System.out.println("three"); }
}
public class Test extends Super {
    int three = (int)Math.PI; // That is, 3
    public static void main(String[] args) {
        Test t = new Test();
        t.printThree();
    }
    @Override
    void printThree() { System.out.println(three); }
}