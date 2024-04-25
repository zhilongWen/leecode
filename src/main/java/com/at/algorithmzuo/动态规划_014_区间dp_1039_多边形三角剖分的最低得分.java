package com.at.algorithmzuo;


// https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/description/


public class 动态规划_014_区间dp_1039_多边形三角剖分的最低得分 {

    public int minScoreTriangulation(int[] values) {

        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f1(values, 0, n - 1, dp);

    }


    public int f1(int[] arr, int l, int r, int[][] dp) {

        if (dp[l][r] != -1) return dp[l][r];

        int ans = Integer.MAX_VALUE;
        if (l == r || l + 1 == r) {
            // 顶点小于 3
            return 0;
        } else {
            for (int m = l + 1; m < r; m++) {
                // l m r
                ans = Math.min(ans, f1(arr, l, m, dp) + f1(arr, m, r, dp) + arr[l] * arr[m] * arr[r]);

            }

        }

        dp[l][r] = ans;

        return ans;

    }

}
