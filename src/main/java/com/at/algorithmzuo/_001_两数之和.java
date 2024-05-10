package com.at.algorithmzuo;

// https://leetcode.cn/problems/two-sum/description/
//     给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//    你可以按任意顺序返回答案。

import java.util.HashMap;

public class _001_两数之和 {


    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);

        }

        return new int[]{};


    }


}
