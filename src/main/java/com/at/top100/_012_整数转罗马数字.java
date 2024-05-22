package com.at.top100;

// https://leetcode.cn/problems/integer-to-roman/description/

public class _012_整数转罗马数字 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            String s = symbols[i];

            while (num >= v) {
                num -= v;
                ans.append(s);
            }

            if (num == 0) break;
        }

        return ans.toString();
    }
}
