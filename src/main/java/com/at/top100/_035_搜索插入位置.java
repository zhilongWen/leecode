package com.at.top100;


// https://leetcode.cn/problems/search-insert-position/

public class _035_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1, ans = r + 1;

        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
