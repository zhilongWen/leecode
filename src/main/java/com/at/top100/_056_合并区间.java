package com.at.top100;

// https://leetcode.cn/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _056_合并区间 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (l, r) -> l[0] - r[0]);

        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] > end) {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
            }

            end = Math.max(end, intervals[i][1]);
        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[][]{});
    }
}
