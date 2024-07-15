package com.at.top200;

// https://leetcode.cn/problems/longest-consecutive-sequence/description/

import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {

    public int longestConsecutive(int[] nums) {

        int res = 0;

        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        for (int x : nums) {

            if (!sets.contains(x - 1)) {

                int y = x;
                while (sets.contains(y + 1)) {
                    y++;
                }

                res = Math.max(y - x + 1, res);
            }
        }

        return res;
    }
}
