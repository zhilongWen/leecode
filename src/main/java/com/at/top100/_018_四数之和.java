package com.at.top100;

// https://leetcode.cn/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[i + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }

                int l = j + 1, r = len - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }

                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return ans;
    }
}
