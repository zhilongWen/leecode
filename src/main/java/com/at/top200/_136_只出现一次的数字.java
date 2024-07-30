package com.at.top200;

// https://leetcode.cn/problems/candy/

public class _136_只出现一次的数字 {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
