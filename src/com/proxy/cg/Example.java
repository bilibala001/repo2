package com.proxy.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ng
 * @date 2019/12/26-9:40
 */
    // 缺少asm的jar包。没时间弄了。 此外CallBack还有其他的写法。
public class Example {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("执行前");
                Object oo = proxy.invokeSuper(o, args);
                System.out.println("执行后");
                return oo;
            }
        });

        Target t = (Target)enhancer.create();
        t.test();
        String s = t.testReturn();
        System.out.println(s);


    }
}
