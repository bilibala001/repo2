package com.thread.lock;

public class FatherClass {

    synchronized public void callFather(){
        try {
            System.out.println("------------Call Father start------");
            Thread.sleep(1000);
            System.out.println("------------Call Father end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

