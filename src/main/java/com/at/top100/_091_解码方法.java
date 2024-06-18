package com.at.top100;

// https://leetcode.cn/problems/decode-ways/description/

import java.util.*;

public class _091_解码方法 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        return dfs(s, 0);
    }

    public int dfs(String str, int idx) {

        if (idx >= str.length()) {
            return 1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }

        int one = 0, two = 0;

        if (str.charAt(idx) != '0') {
            one = dfs(str, idx + 1);
        }

        if (idx + 1 < str.length() && str.charAt(idx) != '0' && isValid(str, idx)) {
            two = dfs(str, idx + 2);
        }

        cache.put(idx, one + two);

        return cache.get(idx);
    }

    public boolean isValid(String str, int idx) {

        int a = str.charAt(idx) - '0';
        int b = str.charAt(idx + 1) - '0';

        int sum = a * 10 + b;

        return sum >= 10 && sum <= 26;
    }

    public int numDecodings1(String s) {

        char[] arr = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {

            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }

            if (i > 1 && arr[i - 2] != '0' && ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0')) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }
}
