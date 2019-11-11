package com.thread.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ng
 * @date 2019/11/6-17:32
 */
public class AfterWait {
    public static void main(String[] args) {
        General general = new General(1);
        ExecutorService exec = Executors.newFixedThreadPool(6);
        exec.execute(new M3Task(general));
        exec.execute(new M2Task(general));
        exec.execute(new M1Task(general));
        exec.shutdown();

    }
}
