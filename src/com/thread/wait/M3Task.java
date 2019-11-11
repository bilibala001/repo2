package com.thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/6-19:23
 */
public class M3Task implements Runnable {
    private General general;

    public M3Task(General general) {
        this.general = general;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("进入m3线程了==================");
                general.m3wait();
                System.out.println("m3执行了-------------");
                TimeUnit.MILLISECONDS.sleep(1000);
                general.m3();

            }
        } catch (InterruptedException e) {
            System.out.println("异常中断啦啦啦");
        }
    }
}
