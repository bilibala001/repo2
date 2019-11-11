package com.thread.sumarray;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author ng
 * @date 2019/11/9-9:22
 */
public class RescArray {


    @Test
    public void fn1() throws ExecutionException, InterruptedException {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5, 6};
        int[] arr3 = new int[]{7, 8, 9};
        int[][] arr = {arr1, arr2, arr3};
        Future<Integer>[] futures = new Future[arr.length];
        Integer sum = 0;
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < arr.length; i++) {
            futures[i] = pool.submit(new ArrayTask(arr[i]));
            // 执行线程
            Integer integer = futures[i].get();
            sum += integer;
        }
        System.out.println(Thread.currentThread().getName() + "得到的总和为： " + sum);
        pool.shutdownNow();
    }
}
