package com.at.top200;

// https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/

public class _153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {

        int l = 0,r = nums.length - 1;

        while (l < r){

            int m = l + ((r-  l) >> 1);

            if (nums[m] < nums[r]){
                r = m;
            }else {
                l = m + 1;
            }
        }

        return nums[l];
    }
}
