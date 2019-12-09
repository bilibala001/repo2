package com.thread.lock;

/**
* @author ng
* @date 2019/12/8-19:03
*/
class SunClass extends FatherClass {  //

   synchronized public void callSon(){
       try {
           System.out.println("------------Call Son start------");
           Thread.sleep(1000);
           System.out.println("------------Call Son end------");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

}
