package com.list.thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/6-19:23
 */
public class M1Task implements Runnable {
    private General general;

    public M1Task(General general) {
        this.general = general;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("进入m1线程了==================");
                general.m1wait();
                System.out.println("m1执行了-------------");
                TimeUnit.MILLISECONDS.sleep(1000);
                general.m1();

            }
        } catch (InterruptedException e) {
            System.out.println("异常中断啦啦啦");
        }
    }
}
