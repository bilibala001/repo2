package com.thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/5-13:18
 * 测试sleep，唤醒后从哪里开始执行。
 * 结论： 从上次的位置继续。
 */
public class Add implements Runnable {

    public static void main(String[] args) {
        new Thread(new Add()).start();
    }

    @Override
    public void run() {
        int i = 0;
        while (i<=5){
            i=6;
            System.out.println("sleep前--------------");
            try {
                TimeUnit.MILLISECONDS.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep后***********************************");
            i++;
        }
    }
}
