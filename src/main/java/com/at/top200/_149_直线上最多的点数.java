package com.at.top200;

// https://leetcode.cn/problems/max-points-on-a-line/description/

public class _149_直线上最多的点数 {

    public int maxPoints(int[][] points) {

        int n = points.length, ans = 1;

        for (int i = 0; i < n; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];

                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = points[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        cnt++;
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
