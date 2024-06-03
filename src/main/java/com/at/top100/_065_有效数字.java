package com.at.top100;

// https://leetcode.cn/problems/valid-number/description/

public class _065_有效数字 {

    char[] arr;
    int len;

    public boolean isNumber(String s) {

        arr = s.trim().toCharArray();
        len = arr.length;

        boolean dot = false, e = false;


        for (int i = 0; i < len; i++) {

            if (isNum(i)) {
                continue;
            }

            char c = arr[i];
            if (c == '-' || c == '+') {
                if (1 == len) {
                    return false;
                }
                if (!(i == 0 || (arr[i - 1] == 'e' || arr[i - 1] == 'E'))) {
                    return false;
                }
            } else if (c == '.') {
                if (e || dot) {
                    return false;
                }
                if (!(isNum(i - 1) || isNum(i + 1))) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (e || i == 0 || i + 1 >= len) {
                    return false;
                }

                boolean flag = arr[i - 1] != '+' && arr[i - 1] != '-';

                if (!(flag && isNum(i + 1) || ((arr[i + 1] == '-' || arr[i + 1] == '+') && isNum(i + 2)))) {
                    return false;
                }
                e = true;
            } else {
                return false;
            }

        }

        return true;
    }

    public boolean isNum(int idx) {

        if (idx >= len || idx < 0) {
            return false;
        }

        return arr[idx] >= '0' && arr[idx] <= '9';
    }
}
