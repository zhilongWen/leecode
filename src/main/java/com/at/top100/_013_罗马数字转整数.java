package com.at.top100;

// https://leetcode.cn/problems/roman-to-integer/description/

public class _013_罗马数字转整数 {

    public int romanToInt(String s) {

        int sum = 0;
        int fNUm = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            int value = getValue(s.charAt(i));
            if (value > fNUm) {
                sum -= fNUm;
            } else {
                sum += fNUm;
            }

            fNUm = value;
        }

        sum += fNUm;

        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
