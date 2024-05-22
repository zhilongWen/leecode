package com.at.top100;

// https://leetcode.cn/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;

        for (int k = 0; k < len - 2; k++) {

            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            int l = k + 1, r = len - 1;

            while (l < r) {

                int sum = nums[k] + nums[l] + nums[r];

                if (sum < 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else if (sum > 0) {
                    while (l < r && nums[r] == nums[--r]) ;
                } else {
                    ans.add(Arrays.asList(nums[k], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                }
            }
        }

        return ans;
    }
}
