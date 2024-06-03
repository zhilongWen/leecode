package com.at.top100;

// https://leetcode.cn/problems/plus-one/description/

public class _066_加一 {

    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int sum = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                sum += 1;
            }
            int a = sum + digits[i];
            digits[i] = a % 10;
            sum = a / 10;
            if (sum == 0) {
                return digits;
            }
        }

        digits = new int[len + 1];
        digits[0] = 1;

        return digits;
    }
}
