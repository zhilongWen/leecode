package com.at.top100;

import java.util.HashMap;
import java.util.Map;

public class _001_两数之和 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int v = target - nums[i];
            if (map.containsKey(v)){
                return new int[]{map.get(v),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
