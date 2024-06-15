package com.at.algorithmzuo;

// https://leetcode.cn/problems/daily-temperatures/description/

public class 单调栈_003_907_子数组的最小值之和 {

    public static int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long ans = 0;
        int[] stack = new int[n];
        int r = 0, curr, left;

        for (int i = 0; i < n; i++) {

            while (r > 0 && arr[i] <= arr[stack[r - 1]]) {
                curr = stack[--r];
                left = r > 0 ? stack[r - 1] : -1;
                ans = (ans + (long) (curr - left) * (i - curr) * arr[curr]) % MOD;
            }

            stack[r++] = i;
        }

        while (r > 0) {
            curr = stack[--r];
            left = r > 0 ? stack[r - 1] : -1;
            ans = (ans + (long) (curr - left) * (n - curr) * arr[curr]) % MOD;
        }

        return (int) ans;
    }
}
