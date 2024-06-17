package com.at.top100;

// https://leetcode.cn/problems/scramble-string/

import java.util.HashMap;
import java.util.Map;

public class _087_扰乱字符串 {

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int[] cnts = new int[26];

        for (int i = 0; i < n; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            // 判断 S1 的子树能否变为 S2 相应部分
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            // S1 两个子树先进行了交换，然后判断 S1 的子树能否变为 S2 相应部分
            if (isScramble(s1.substring(i), s2.substring(0, n - i))
                    && isScramble(s1.substring(0, i), s2.substring(n - i))) {
                return true;
            }
        }

        return false;
    }


    Map<String, Integer> cache = new HashMap<>();

    public boolean isScramble1(String s1, String s2) {
        return f1(s1, s2);
    }

    public boolean f1(String s1, String s2) {

        int res = cache.getOrDefault(s1 + "#" + s2, -1);

        if (res == 1) {
            return true;
        } else if (res == 0) {
            return false;
        }

        if (s1.length() != s2.length()) {
            cache.put(s1 + "#" + s2, 0);
            return false;
        }

        if (s1.equals(s2)) {
            cache.put(s1 + "#" + s2, 1);
            return true;
        }

        int n = s1.length();
        int[] cnts = new int[26];

        for (int i = 0; i < n; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnts[i] != 0) {
                cache.put(s1 + "#" + s2, 0);
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                cache.put(s1 + "#" + s2, 1);
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                cache.put(s1 + "#" + s2, 1);
                return true;
            }

        }

        cache.put(s1 + "#" + s2, 0);
        return false;
    }

    public boolean isScramble2(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int[] cnts = new int[26];

        for (int i = 0; i < n; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }

        boolean[][][] dp = new boolean[n + 1][n][n];

        for (int i = 1; i <= n; i++) {

            //S1 开始的地方
            for (int a1 = 0; a1 + i <= n; a1++) {

                //S2 开始的地方
                for (int a2 = 0; a2 + i <= n; a2++) {

                    if (i == 1) {
                        dp[i][a1][a2] = s1.charAt(a1) == s2.charAt(a2);
                    } else {
                        //遍历切割后的左半部分长度
                        for (int q = 1; q < i; q++) {
                            dp[i][a1][a2] =
                                    dp[q][a1][a2] && dp[i - q][a1 + q][a2 + q]
                                            ||
                                            dp[q][a1][a2 + i - q] && dp[i - q][a1 + q][a2];
                            //如果当前是 true 就 break，防止被覆盖为 false
                            if (dp[i][a1][a2]) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[n][0][0];
    }
}
