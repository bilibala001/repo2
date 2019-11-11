package com.thread.entrances;

import java.util.Random;

/**
 * @author ng
 * @date 2019/11/5-8:26
 */
public class Count {
    private int count = 0;
    private Random random = new Random(22);

    // setter
    public synchronized int increment(){
        int temp = count;
        if(random.nextBoolean()){
            Thread.yield();}
        return (count= ++temp);
    }
    // getter
    public synchronized int getCount(){
        return count;
    }

}
