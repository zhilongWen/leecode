package com.at.algorithmzuo;


// https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/description/


import java.util.Arrays;

public class 动态规划_015_区间dp_1547_切棍子的最小成本 {

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;
        Arrays.sort(cuts);

        // 1 100 230 300
        // 0 1   2   3
        // ==>
        // 0 1 100 230 300 n
        // 0 1 2   3   4   5

        int arr[] = new int[m + 2];
        arr[0] = 0;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;

        int[][] dp = new int[m + 2][m + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -1;
            }
        }


        return f1(arr, 1, m, dp);
    }

    // 切点[l....r]，决定一个顺序
    // 让切点都切完，总代价最小
    public int f1(int[] arr, int l, int r, int[][] dp) {

        if (l > r) return 0;

        if (l == r) return arr[r + 1] - arr[l - 1];

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int ans = Integer.MAX_VALUE;
        for (int m = l; m <= r; m++) {
            // l ... r
            // l l+1 l+2 .. r
            ans = Math.min(ans, f1(arr, m + 1, r, dp) + f1(arr, l, m - 1, dp));
        }

        ans += arr[r + 1] - arr[l - 1];

        dp[l][r] = ans;

        return ans;

    }

}
