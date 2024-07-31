package com.at.top200;

// https://leetcode.cn/problems/word-break/description/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dic = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dic.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
