package com.exception;

import org.junit.Test;

/**
 * @author ng
 * @date 2019/11/13-11:34
 */
public class ExecOrder {
    /**
     * 模拟下 aop的切点，确定下aop的执行顺序。
     */
    @Test
    public void fn1() {
        String s ;
        try {
            try {
                System.out.println("@Before:内层try 里面的代码，在meth前面执行");
                 s = new ExecOrder().meth();
            } finally {
                System.out.println("@After:内层try 的finally,如果写在meth后面有可能执行不到");
            }
            System.out.println("@AfterRetunning:在外层try，出了内层try finally之后 。可以对返回值加工吗?"+s);
        } catch (ArithmeticException e) {
            System.out.println("@AfterException:发生异常了");
        }

    }

    protected String meth() throws ArithmeticException {
        System.out.println("Method:meth执行了");
//        int i = 1 / 0;
        return "meth";
    }
}
