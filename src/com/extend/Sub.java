package com.extend;

/**
 * @author ng
 * @date 2019/11/12-16:24
 */
public class Sub extends Parent{
    public Sub() {
        System.out.println("sub constructor");
    }
    // 不能在toString里面调用this，否则会递归。
    @Override
    public String toString() {
        return "Sub{" +
                "sub_name='" + name + '\'' +
                '}';
    }
}
