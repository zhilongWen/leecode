package com.at.algorithmzuo;

// https://leetcode.cn/problems/daily-temperatures/description/

public class 单调栈_002_739_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n];

        for (int i = 0, r = 0, curr; i < n; i++) {

            // 待压入的元元素比栈顶的大
            while (r > 0 && temperatures[i] > temperatures[stack[r - 1]]) {
                curr = stack[--r];
                ans[curr] = i - curr;
            }

            // 待处理的元素比栈顶的小或等于
            stack[r++] = i;

        }

        return ans;
    }
}
