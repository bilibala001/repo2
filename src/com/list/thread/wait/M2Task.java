package com.list.thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/6-19:23
 */
public class M2Task implements Runnable {
    private General general;

    public M2Task(General general) {
        this.general = general;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("进入m2线程了==================");
                general.m2wait();
                System.out.println("m2执行了-------------");
                TimeUnit.MILLISECONDS.sleep(1000);
                general.m2();


            }
        } catch (InterruptedException e) {
            System.out.println("异常中断啦啦啦");
        }
    }
}
