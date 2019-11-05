package com.list.thread.entrances;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/5-8:31
 */
public class Entrance implements Runnable {
    private static Count count = new Count();
    private final int id;
    private int number = 0;
    private static volatile boolean cancled = false;
    private static List<Entrance> list = new ArrayList<>();

    public Entrance(int id) {
        this.id = id;
        list.add(this); // 防止this被GC
    }
    public static void cancle(){
        cancled = true;
    }

    @Override
    public void run() {
        while (!cancled){
            synchronized (this){
                number++;
            }
            // 总数再增加
            System.out.println(this+" total :"+count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("stopping "+this);
    }
    // 先不加同步
    public synchronized int getValue(){
        return number;
    }
    // 这个不用加同步吗？ static方法可以保证可见性吗？
    public static int getTotalCount(){
        return count.getCount();
    }

    public static int sumEntrances(){
        int sum = 0;
        for (Entrance e :list) {
            sum+= e.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Entrance"+id+"  :"+getValue();
    }
}
