package com.at.algorithmzuo;

// https://leetcode.cn/problems/maximal-rectangle/description/

import java.util.Arrays;

public class 单调栈_003_85_最大矩形 {

    int[] stack;
    int[] height;

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        stack = new int[m];
        height = new int[m];
        Arrays.fill(height, 0);
        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }

            ans = Math.max(ans, f());

        }

        return ans;
    }

    public int f() {

        int ans = 0, r = 0, curr, left;
        for (int i = 0; i < height.length; i++) {

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
            ans = Math.max(ans, (height.length - left - 1) * height[curr]);
        }

        return ans;
    }
}
