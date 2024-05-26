package com.at.top100;


// https://leetcode.cn/problems/longest-valid-parentheses/

import java.util.Stack;

public class _032_最长有效括号 {

    public int longestValidParentheses(String s) {

        int ans = 0, len = s.length();
        if (len == 0) {
            return ans;
        }

        int[] dp = new int[len];
        dp[0] = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    public int longestValidParentheses1(String s) {

        char[] arr = s.toCharArray();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
