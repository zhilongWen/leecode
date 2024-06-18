package com.at.top100;

// https://leetcode.cn/problems/subsets-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _090_子集II {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        f(nums, 0, false);

        return new ArrayList<>(ans);
    }

    public void f(int[] nums, int idx, boolean choosePre) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        f(nums, idx + 1, false);

        if (!choosePre && idx > 0 && nums[idx - 1] == nums[idx]) {
            return;
        }

        buffer.add(nums[idx]);
        f(nums, idx + 1, true);
        buffer.remove(buffer.size() - 1);
    }
}
