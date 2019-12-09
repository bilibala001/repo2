package com.thread.reentrant;

/**
 * @author ng
 * @date 2019/12/8-10:19
 */
public class SuperSyncObj {
    public synchronized void methodA() {
        System.out.println(Thread.currentThread().getName()+"super class running methodA");
    }
}
