package com.thread.wait;

import sun.reflect.generics.tree.VoidDescriptor;

import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/6-17:34
 */
public class General {
    private int target = 1;

    public General(int target) {
        this.target = target;
    }

    // 目的是target==1 调用m1； ==2，调用m2; ==3 调用m3 ；
    // 看wait被唤醒后会不会判断while的条件，2是看wait被唤醒的执行的位置。
    // 被唤醒后的线程，不会再次while判断了。
    public synchronized void m1() throws InterruptedException {
        target++;
        System.out.println("m1方法 ++ ; i = "+target);
        notifyAll();
        System.out.println("m1方法唤醒其他线程了。。。。。。。。。。。。。。。。。");
    }

    public synchronized void m2() throws InterruptedException {
        target++;
        System.out.println("m2方法 ++ ; i = "+target);
        notifyAll();
        System.out.println("m2方法唤醒其他线程了。。。。。。。。。。。。。。。。。");
    }

    public synchronized void m3() throws InterruptedException {
        target++;
        System.out.println("m1方法 ++ ; i = "+target);
        notifyAll();
        System.out.println("m3方法唤醒其他线程了。。。。。。。。。。。。。。。。。");
    }

    // notify方法：
    public synchronized void m1wait() throws InterruptedException {
        while (target % 3 + 1 != 1) {
          //  System.out.println("m1.wait前**************** target = " + target);
            wait();
            //System.out.println("m1.wait后。。。 target = " + target);
        }
    }

    public synchronized void m2wait() throws InterruptedException {
        while (target % 3 + 1 != 2) {
          //  System.out.println("m2.wait前**************** target = " + target);
            wait();
            //System.out.println("m2.wait后。。。 target = " + target);
        }
    }

    public synchronized void m3wait() throws InterruptedException {
        while (target % 3 + 1 != 3) {
          //  System.out.println("m3.wait前**************** target = " + target);
            wait();
            //System.out.println("m3.wait后。。。 target = " + target);
        }
    }


}
