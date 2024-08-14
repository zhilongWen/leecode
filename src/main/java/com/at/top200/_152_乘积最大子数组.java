package com.at.top200;

// https://leetcode.cn/problems/maximum-product-subarray/description/

public class _152_乘积最大子数组 {

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int num : nums) {

            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(imax, max);
        }

        return max;
    }
}
