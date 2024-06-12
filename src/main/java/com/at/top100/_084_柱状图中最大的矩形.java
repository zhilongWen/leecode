package com.at.top100;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/description/

import java.util.Arrays;
import java.util.Stack;

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
        if (len == 0) {
            return heights[0];
        }
        int[] right = new int[len];
        int[] left = new int[len];
        Arrays.fill(right, len);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}
