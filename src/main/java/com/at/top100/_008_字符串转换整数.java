package com.at.top100;

// https://leetcode.cn/problems/string-to-integer-atoi/description/

public class _008_字符串转换整数 {

    public int myAtoi(String s) {

        int len = s.length();
        char[] arr = s.toCharArray();

        int idx = 0;
        while (idx < len && arr[idx] == ' ') {
            idx++;
        }
        if (idx == len) return 0;

        int flag = 1;
        char c = arr[idx];
        if (c == '+') {
            idx += 1;
        } else if (c == '-') {
            flag = -1;
            idx += 1;
        }


        int ans = 0;
        while (idx < len) {

            c = arr[idx];
            if (!(c >= '0' && c <= '9')) break;

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            ans = ans * 10 + flag * (c - '0');
            idx++;
        }

        return ans;
    }
}
