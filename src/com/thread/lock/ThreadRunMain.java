package com.thread.lock;

/**
 * @author ng
 * @date 2019/12/8-19:03
 */
class ThreadRunMain {
    public static void main(String[] args) {
        testSyncFSThread();
    }

    public static void testSyncFSThread(){
        SunClass sc = new SunClass();
        SunThread st = new SunThread(sc);
        st.start();
        /*FatherClass fc = new FatherClass();
        FatherThread ft = new FatherThread(fc);
        ft.start();*/
        FatherThread fatherThread = new FatherThread(sc);
        fatherThread.start();

    }
}
