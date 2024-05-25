package com.at.algorithmzuo;

public class KMP_001_28_找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        return kmp(haystack.toCharArray(), needle.toCharArray());
    }

    public int kmp(char[] a, char[] b) {

        // x 是 a 数组要对比的位置
        // y 是 a 数组要对比的位置
        int n = a.length, m = b.length, x = 0, y = 0;

        int[] next = next(b, m);

        while (x < n && y < m) {

            if (a[x] == b[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }

        return y == m ? x - y : -1;
    }

    public int[] next(char[] arr, int m) {

        if (m == 1) {
            return new int[]{-1};
        }

        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;
        // i 表示当前要求的 next 值的位置
        // cnt 表示当前要和前一个字符对比的下标
        int i = 2, cn = 0;

        while (i < m) {

            // arr  0 ... a-1 a ... i-1 i .... m
            // next                  a(除本身外最长的前缀)
            //      0 ... a-1 和 i-2-a ... i-2 完全一样
            if (arr[i - 1] == arr[cn]) {
                next[i++] = ++cn;
            } else {
                if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[i++] = 0;
                }
            }
        }

        return next;
    }
}
