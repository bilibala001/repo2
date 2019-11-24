package com.constructor.whichfirst;

/**
 * @author ng
 * @date 2019/11/14-12:47
 */
public class NoStaticInThisClass {
    private int i = 10;

    public NoStaticInThisClass() {
        i = 77;
    }


   /* public NoStaticInThisClass() {
        System.out.println("无参con");
    }*/

   /* public NoStaticInThisClass(int i) {
       i=5;
    }*/

    public static void main(String[] args) {
        NoStaticInThisClass first = new NoStaticInThisClass();
        System.out.println(first.i);

        //有参构造函数是怎么样呢？ 实验无参就不会调用了
       /* NoStaticInThisClass first = new NoStaticInThisClass(4);
        System.out.println(first.i);*/

        //无参中调用this.i = 1;
        /*NoStaticInThisClass first = new NoStaticInThisClass();
        System.out.println(first.i);*/
    }
}
