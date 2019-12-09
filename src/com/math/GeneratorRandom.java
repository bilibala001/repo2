package com.math;

import org.junit.Test;

import java.util.Random;

/**
 * @author ng
 * @date 2019/12/8-15:37
 */
public class GeneratorRandom {
    private static Random sr=new Random(47);
    @Test
    public void fn1(){
        for (int i = 0; i < 200; i++) {
            int next = GeneratorRandom.sr.nextInt(20);
            System.out.print(next + "\t");
        }
    }
}
