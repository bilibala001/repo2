package com.algorithm;

/**
 * @author ng
 * @date 2019/11/21-10:21
 */
public class Sqrt {
    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        for (Double i = 1d; i <= 1000; i++) {
            Double a = makeSqrt(i, 1D, i);
            System.out.println(a + "\t" + ":" + i);
        }
        System.out.println(System.currentTimeMillis() - current);
    }

    /**
     * @param target 要查找的被开方树
     * @param left   范围最小值
     * @param right  范围最大值
     * @return
     */
    private static Double makeSqrt(Double target, Double left, Double right) {
        if (left == null) {
            throw new IllegalArgumentException("错误的输入，请重新输入");
        }
        while (left < right) {
            double mid = (left + right) / 2;
            if (Math.abs(mid * mid - target) < 0.00001) {
                return mid;
            }
            if (mid * mid > target) {
                right = mid;
//                left = target / mid;
            }
            if (mid * mid < target) {
                left = mid;
//                right = target / mid;
            }
        }
        return left;
    }
}
