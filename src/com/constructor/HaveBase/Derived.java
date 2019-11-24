package com.constructor.HaveBase;

/**
 * @author ng
 * @date 2019/11/14-15:13
 */


public class Derived extends Base {
    public String whenAmISet = "set when declared";

    @Override
    void preProcess() {
        whenAmISet = "set in preProcess()";
    }

    public static void main(String[] args) {
        Derived derived = new Derived();
        System.out.println(derived.whenAmISet);
    }
}

class Base {
    Base() {
        preProcess();
    }

    void preProcess() {
    }
}
