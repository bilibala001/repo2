package com.thread.sumarray;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/11/9-9:55
 */
public class ArrayTask implements Callable<Integer> {
    private int[] arr;

    public ArrayTask() {
    }

    public ArrayTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        TimeUnit.MILLISECONDS.sleep(1100);
        System.out.println(Thread.currentThread().getName() + " 执行结果：" + sum);
        return sum;
    }
}
