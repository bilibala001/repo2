package com.extend;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author ng
 * @date 2019/11/12-16:22
 */
public class PrintThis {
    public static void main(String[] args) {
        Parent sub = new Sub();
        System.out.println(sub.toString());
    }
}
