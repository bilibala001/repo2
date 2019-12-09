package com.thread.reentrant;

/**
 * @author ng
 * @date 2019/12/8-10:37
 */
public class NormalObj {
    public static synchronized void methodC(){
        System.out.println(Thread.currentThread().getName()+"Nomalclass ‘s methodC run ---");
    }
}
