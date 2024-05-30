package com.at.top100;

// https://leetcode.cn/problems/insert-interval/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _057_插入区间 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int i = 0, len = intervals.length;

        while (i < len && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i++]);
        }

        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while (i < len) {
            ans.add(intervals[i++]);
        }

        return ans.toArray(new int[][]{});
    }
}
