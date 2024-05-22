package com.at.top100;

// https://leetcode.cn/problems/regular-expression-matching/description/

public class _010_正则表达式匹配 {

    public boolean isMatch(String s, String p) {

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        return f(sArr, 0, pArr, 0);
    }

    public boolean f(char[] sArr, int i, char[] pArr, int j) {

        if (i == sArr.length) {
            if (j == pArr.length) {
                return true;
            } else {
                return j + 1 < pArr.length && pArr[j + 1] == '*' && f(sArr, i, pArr, j + 2);
            }
        } else if (j == pArr.length) {
            return false;
        } else {

            // j + 1 != *
            // j + 1 = *

            if (j + 1 == pArr.length || pArr[j + 1] != '*') {
                return (sArr[i] == pArr[j] || pArr[j] == '.') && f(sArr, i + 1, pArr, j + 1);
            } else {

                // 不要 j 和 j+1
                boolean p1 = f(sArr, i, pArr, j + 2);

                boolean p2 = (sArr[i] == pArr[j] || pArr[j] == '.') && f(sArr, i + 1, pArr, j);

                return p1 || p2;
            }
        }
    }
}
