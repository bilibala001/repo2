package com.thread.reentrant;

/**
 * @author ng
 * @date 2019/12/8-10:20
 * 测试锁的可重入,结果是父类对象可以重入子类对象的同步代码块。
 */
public class SubSyncObj extends SuperSyncObj {
    @Override
    public synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + "methodA.....");
        try {
            super.methodA();
            // 执行到这里，时，线程在sub上获取锁，因为要执行Normal同步代码，要先获取Normal的锁，但是
            // 不释放Sub上的锁，此时其他线程还是无法获得sub的锁。
            // 那是不是一个线程同时获得多个锁呢？  看到是线程锁的指针指向了NormalClass的锁，等
            // methodC执行完毕，有把指针重新指向Sub或者Super上的锁。
            NormalObj.methodC();
            Thread.sleep(2000);
            methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + "methodB run... ...");
    }

    public static void main(String[] args) {
        SubSyncObj sub = new SubSyncObj();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sub.methodA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sub.methodA();
            }
        }).start();
    }
}
