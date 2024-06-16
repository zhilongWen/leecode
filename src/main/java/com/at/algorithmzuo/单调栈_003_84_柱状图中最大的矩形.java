package com.at.algorithmzuo;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/

public class 单调栈_003_84_柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int[] stack = new int[len];
        int ans = 0, r = 0, curr, left;

        for (int i = 0; i < len; i++) {

            while (r > 0 && heights[i] <= heights[stack[r - 1]]) {
                curr = stack[--r];
                left = r > 0 ? stack[r - 1] : -1;
                ans = Math.max(ans, (i - left - 1) * heights[curr]);
            }

            stack[r++] = i;
        }

        while (r > 0) {
            curr = stack[--r];
            left = r > 0 ? stack[r - 1] : -1;
            ans = Math.max(ans, (len - left - 1) * heights[curr]);
        }


        return ans;
    }
}
