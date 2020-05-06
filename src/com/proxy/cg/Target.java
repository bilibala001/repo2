package com.proxy.cg;

/**
 * @author ng
 * @date 2019/12/26-9:48
 */
public class Target {
    public void test(){
        System.out.println("target 。test method run 。。。");
    }
    public String testReturn(){
        System.out.println("有返回值的启动了");
        return "aaa";
    }
}
