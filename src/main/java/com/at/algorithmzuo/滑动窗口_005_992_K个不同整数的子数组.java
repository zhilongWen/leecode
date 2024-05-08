package com.at.algorithmzuo;


// K个不同整数的子数组
// 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
// 如果 nums 的某个子数组中不同整数的个数恰好为 k
// 则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
// 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
// 子数组 是数组的 连续 部分。
// 测试链接 : https://leetcode.cn/problems/subarrays-with-k-different-integers/


import java.util.Arrays;

public class 滑动窗口_005_992_K个不同整数的子数组 {


    public static void main(String[] args) {

        int[] arr = {1,2,1,2,3};

        new 滑动窗口_005_992_K个不同整数的子数组().subarraysWithKDistinct(arr,2);

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }

    public static int MAXN = 20001;

    public static int[] cnts = new int[MAXN];

    // arr中有多少子数组，数字种类不超过k
    // arr的长度是n，arr里的数值1~n之间
    public int f(int[] nums, int k) {

        Arrays.fill(cnts, 1, nums.length + 1, 0);

        int ans = 0;

        for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {

            // r(刚进)
            if (++cnts[nums[r]] == 1) {
                sum++;
            }

            // l.....r    要求不超过3种，已经4种，l往右（吐数字）
            while (sum > k) {
                if (--cnts[nums[l++]] == 0) {
                    sum--;
                }
            }

            // l.....r不超过了
            // 0...3
            // 0~3
            // 1~3
            // 2~3
            // 3~3
            ans += r - l + 1;

        }


        return ans;

    }

}
