package com.at.top200;

// https://leetcode.cn/problems/surrounded-regions/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _131_分割回文串 {

    String str;
    List<List<String>> ans = new ArrayList<>();
    Deque<String> buffer = new LinkedList<>();

    public List<List<String>> partition(String s) {

        this.str = s;
        f(0);

        return ans;
    }

    public void f(int idx) {

        if (idx >= str.length()) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = idx; i < str.length(); i++) {

            if (!isPalindrome(idx, i)) {
                continue;
            }

            String s = str.substring(idx, i + 1);
            buffer.addLast(s);

            f(i + 1);

            buffer.removeLast();
        }
    }

    public boolean isPalindrome(int left, int right) {

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    // --
    List<List<String>> ans2 = new ArrayList<>();
    List<String> buffer2 = new ArrayList<>();
    String str2;
    boolean[][] dp;

    public List<List<String>> partition2(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();

        // dp[i][j] 代表 [i, j] 这一段是否为回文串
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {

                // 当 [i, j] 只有一个字符时，必然是回文串
                if (i == j) {
                    dp[i][j] = true;
                } else {

                    // 当 [i, j] 长度为 2 时，满足 arr[i] == arr[j] 即回文串
                    if (j - i + 1 == 2) {
                        dp[i][j] = arr[i] == arr[j];
                    } else {
                        // 当 [i, j] 长度大于 2 时，满足 (arr[i] == arr[j] && dp[i + 1][j - 1]) 即回文串
                        dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
                    }
                }
            }
        }

        this.str2 = s;
        this.dp = dp;

        dfs(0);

        return ans2;
    }

    public void dfs(int idx) {

        if (idx == str2.length()) {
            ans2.add(new ArrayList<>(buffer2));
            return;
        }

        for (int i = idx; i < str2.length(); i++) {
            if (dp[idx][i]) {
                buffer2.add(str2.substring(idx, i + 1));
                dfs(i + 1);
                buffer2.remove(buffer2.size() - 1);
            }
        }
    }
}
