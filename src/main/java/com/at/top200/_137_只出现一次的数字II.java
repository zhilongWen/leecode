package com.at.top200;

// https://leetcode.cn/problems/candy/

public class _137_只出现一次的数字II {

    public int singleNumber(int[] nums) {

        int a = 0, b = 0;

        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }

        return b;
    }
}
