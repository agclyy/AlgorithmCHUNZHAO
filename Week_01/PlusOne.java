package com.agclyy.better.algorithm.week01.homework;

import java.math.BigDecimal;

/**
 * 66. Plus One
 */
public class PlusOne {


    public static int[] plusOne(int[] digits) {
        BigDecimal digit = BigDecimal.ZERO;
        int j = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digit = digit.add(BigDecimal.valueOf(digits[i] * Math.pow(10, j++)));
        }
        digit = digit.add(BigDecimal.ONE);
        String ss = String.valueOf(digit.toBigInteger());
        int[] result = new int[ss.length()];
        for (int i = 0; i < ss.length(); i++) {
            result[i] = Integer.valueOf(ss.substring(i, i + 1));
        }
        return result;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
