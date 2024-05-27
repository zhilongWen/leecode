package com.at.top100;

// https://leetcode.cn/problems/wildcard-matching/

public class _044_通配符匹配 {

    public boolean isMatch(String s, String p) {
        return f(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean f(char[] s, int i, char[] p, int j) {

        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == '*' && f(s, i, p, j + 1);
            }
        } else if (j == p.length) {
            return false;
        } else {
            if (p[j] != '*') {
                return (s[i] == p[j] || p[j] == '?') && f(s, i + 1, p, j + 1);
            } else {
                return f(s, i + 1, p, j) || f(s, i, p, j + 1);
            }
        }
    }

    int[][] dp;

    public boolean isMatch1(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        return f1(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean f1(char[] s, int i, char[] p, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        boolean ans;
        if (i == s.length) {
            if (j == p.length) {
                ans = true;
            } else {
                ans = p[j] == '*' && f1(s, i, p, j + 1);
            }
        } else if (j == p.length) {
            ans = false;
        } else {
            if (p[j] != '*') {
                ans = (s[i] == p[j] || p[j] == '?') && f1(s, i + 1, p, j + 1);
            } else {
                ans = f1(s, i + 1, p, j) || f1(s, i, p, j + 1);
            }
        }

        dp[i][j] = ans ? 1 : 2;

        return ans;
    }
}
