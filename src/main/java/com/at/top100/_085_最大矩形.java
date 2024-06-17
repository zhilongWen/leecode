package com.at.top100;

// https://leetcode.cn/problems/maximal-rectangle/

public class _085_最大矩形 {


    int[] height;
    int[] stack;

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        height = new int[m];
        stack = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }

            ans = Math.max(ans, f(m));
        }


        return ans;
    }


    public int f(int n) {

        int ans = 0, r = 0, curr, left;

        for (int i = 0; i < n; i++) {

            while (r > 0 && height[i] <= height[stack[r - 1]]) {
                curr = stack[--r];
                left = r > 0 ? stack[r - 1] : -1;
                ans = Math.max(ans, (i - left - 1) * height[curr]);
            }

            stack[r++] = i;
        }

        while (r > 0) {
            curr = stack[--r];
            left = r > 0 ? stack[r - 1] : -1;
            ans = Math.max(ans, (n - left - 1) * height[curr]);
        }

        return ans;
    }
}
