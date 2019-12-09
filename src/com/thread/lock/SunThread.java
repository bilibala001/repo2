package com.thread.lock;

/**
* @author ng
* @date 2019/12/8-19:03
*/
class SunThread extends Thread {
   private SunClass s;

   public SunThread(SunClass s) {
       this.s = s;
   }

   @Override
   public void run() {
       super.run();
       s.callSon();
   }
}
