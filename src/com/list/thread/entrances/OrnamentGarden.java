package com.list.thread.entrances;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/5-8:59
 */
public class OrnamentGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancle();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("some tasks were not terminated !");
        }
        System.out.println("Total " + Entrance.getTotalCount());
        System.out.println("Sum of entrances :  " + Entrance.sumEntrances());
    }
}
