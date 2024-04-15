package com.at.algorithmzuo;

// https://leetcode.cn/problems/wildcard-matching/description/

public class 动态规划_010_完全背包_44_通配符匹配 {

    public boolean isMatch(String s, String p) {

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        return f1(sChars, pChars, 0, 0);

    }

    // s[i....]能不能被p[j....]完全匹配出来
    public static boolean f1(char[] s, char[] p, int i, int j) {

        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == '*' && f1(s, p, i, j + 1);
            }
        } else if (j == p.length) {
            return false;
        } else {

            if (p[j] != '*') {
                return (s[i] == p[j] || p[j] == '?') && f1(s, p, i + 1, j + 1);
            } else {
                return f1(s, p, i, j + 1) || f1(s, p, i + 1, j);
            }
        }
    }


    // 记忆化搜索
    public static boolean isMatch2(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        int n = s.length;
        int m = p.length;
        // dp[i][j] == 0，表示没算过
        // dp[i][j] == 1，表示没算过答案是true
        // dp[i][j] == 2，表示没算过答案是false
        int[][] dp = new int[n + 1][m + 1];
        return f2(s, p, 0, 0, dp);
    }

    public static boolean f2(char[] s, char[] p, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = p[j] == '*' && f2(s, p, i, j + 1, dp);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (p[j] != '*') {
                ans = (s[i] == p[j] || p[j] == '?') && f2(s, p, i + 1, j + 1, dp);
            } else {
                ans = f2(s, p, i + 1, j, dp) || f2(s, p, i, j + 1, dp);
            }
        }
        dp[i][j] = ans ? 1 : 2;
        return ans;
    }

}
