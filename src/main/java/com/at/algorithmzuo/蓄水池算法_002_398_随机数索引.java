package com.at.algorithmzuo;

import java.util.Random;

// https://leetcode.cn/problems/random-pick-index/

public class 蓄水池算法_002_398_随机数索引 {


    class Solution {

        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {

            // 在 nums[0...n-1] 中 num[i] = target 出现的次数
            int cnt = 0;

            // 最终结果的索引，应为一定存在
            int ans = -1;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == target) {
                    ++cnt;
                    if (random.nextInt(cnt) == 0) {
                        ans = i;
                    }
                }

            }

            return ans;
        }
    }


}
