package com.at.top100;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/description/

public class _084_柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {

            int h = heights[i];

            int l = i, r = i;
            while (l - 1 >= 0 && heights[l - 1] >= h) {
                l--;
            }
            while (r + 1 < len && heights[r + 1] >= h) {
                r++;
            }

            ans = Math.max(ans, (r - l + 1) * h);

        }

        return ans;
    }

    public int largestRectangleArea1(int[] heights) {

        int len = heights.length;
        int[] stack = new int[len];
        int r = 0, left = 0, curr, ans = 0;

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
