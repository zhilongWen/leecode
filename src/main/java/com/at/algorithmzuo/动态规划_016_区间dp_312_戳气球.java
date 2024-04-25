package com.at.algorithmzuo;


// https://leetcode.cn/problems/burst-balloons/description/


import java.util.Arrays;

public class 动态规划_016_区间dp_312_戳气球 {


    public int maxCoins(int[] nums) {

        // a b c d e
        // 0 1 2 3 4
        // =>
        // 1 a b c d e 1
        // 0 1 2 3 4 5 6

        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return f(arr, 1, n, dp);


    }


    // arr[l...r]这些气球决定一个顺序，获得最大得分返回！
    // 一定有 : arr[l-1]一定没爆！
    // 一定有 : arr[r+1]一定没爆！
    // 尝试每个气球最后打爆
    public int f(int[] arr, int l, int r, int[][] dp) {

        if (dp[l][r] != -1) return dp[l][r];

        int ans = Integer.MIN_VALUE;
        if (l == r) {
            // [l...r] 只有一个
            ans = arr[l - 1] * arr[l] * arr[r + 1];
        } else {
            ans = Math.max(
                    // l 最后爆
                    arr[l - 1] * arr[l] * arr[r + 1] + f(arr, l + 1, r, dp),
                    // r 最后爆
                    arr[l - 1] * arr[r] * arr[r + 1] + f(arr, l, r - 1, dp)
            );

            for (int k = l + 1; k < r; k++) {
                // k位置的气球最后打爆
                // [l+1 ... r]
                // l.....k k+1 ... r
                ans = Math.max(
                        ans,
                        arr[k] * arr[l - 1] * arr[r + 1] + f(arr, l, k - 1, dp) + f(arr, k + 1, r, dp)
                );

            }
        }

        dp[l][r] = ans;

        return ans;

    }

}
