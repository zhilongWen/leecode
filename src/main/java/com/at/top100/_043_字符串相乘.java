package com.at.top100;

// https://leetcode.cn/problems/multiply-strings/

public class _043_字符串相乘 {

    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1) || "1".equals(num2)) {
            return "1".equals(num1) ? num2 : num1;
        }


        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {

            int a = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int b = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + a * b;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            builder.append(res[i]);
        }

        return builder.toString();
    }
}
