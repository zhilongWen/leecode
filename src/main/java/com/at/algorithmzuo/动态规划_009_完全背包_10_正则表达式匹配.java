package com.at.algorithmzuo;

import java.io.*;
import java.util.Arrays;

// https://leetcode.cn/problems/regular-expression-matching/

public class 动态规划_009_完全背包_10_正则表达式匹配 {

    public boolean isMatch(String s, String p) {

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        return f1(sChars, pChars, 0, 0);

    }

    public boolean f1(char[] s, char[] p, int i, int j) {

        if (i == s.length) {
            // s 没了
            if (j == p.length) {
                // p 也没了
                return true;
            } else {
                // p 还有
                // s []
                //   i
                // p [a*b*c*...
                //    j
                return j + 1 < p.length && p[j + 1] == '*' && f1(s, p, i, j + 2);
            }
        } else if (j == p.length) {
            // p 没了 s 还有
            return false;
        } else {
            // s 和 p 都有
            // s[i...]
            // p[j...]

            // p j+1 不是 *
            if (j + 1 == p.length || p[j + 1] != '*') {
                // s[a]
                // p[ab]
                // p[.]
                return (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j + 1);
            } else {
                // p j+1 是 *

                // s[abc]
                // p[a*abc]
                // 不要 j 和 j+1
                boolean p1 = f1(s, p, i, j + 2);

                // 要 j 和 j+1
                // s[abcj]
                // p[.*] => 变为 ....
                // p[a*abcj]

                boolean p2 = (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j);
                return p1 || p2;

            }
        }

    }

    // 记忆化搜索
    public boolean isMatch2(String s, String p) {

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int n = sChars.length;
        int m = pChars.length;
        // dp[i][j] == 0，表示没算过
        // dp[i][j] == 1，表示没算过答案是true
        // dp[i][j] == 2，表示没算过答案是false
        int[][] dp = new int[n + 1][m + 1];
        return f2(sChars, pChars, 0, 0, dp);

    }

    private boolean f2(char[] s, char[] p, int i, int j, int[][] dp) {

        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = j + 1 < p.length && p[j + 1] == '*' && f2(s, p, i, j + 2, dp);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (j + 1 == p.length || p[j + 1] != '*') {
                ans = (s[i] == p[j] || p[j] == '.') && f2(s, p, i + 1, j + 1, dp);
            } else {
                ans = f2(s, p, i, j + 2, dp) || ((s[i] == p[j] || p[j] == '.') && f2(s, p, i + 1, j, dp));
            }
        }

        dp[i][j] = ans ? 1 : 2;
        return ans;

    }

}
