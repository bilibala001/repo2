package com.thread.lock;

/**
* @author ng
* @date 2019/12/8-19:03
*/
class FatherThread extends Thread {
   private FatherClass f;
   public FatherThread(FatherClass f) {
       this.f = f;
   }
   @Override
   public void run() {
       super.run();
       f.callFather();
   }
}
