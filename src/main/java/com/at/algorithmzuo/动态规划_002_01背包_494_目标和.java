package com.at.algorithmzuo;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.DoublePredicate;

public class 动态规划_002_01背包_494_目标和 {


    public int findTargetSumWays(int[] nums, int target) {
        return f(nums, target, 0, 0);
    }

    // dp[0...i] 累加和是 sum
    public int f(int[] nums, int target, int i, int sum) {

        if (i == nums.length) return sum == target ? 1 : 0;

        // i 是 -
        // i 是 +
        return f(nums, target, i + 1, sum - nums[i]) + f(nums, target, i + 1, sum + nums[i]);

    }


    // hash 表
    public int findTargetSumWays1(int[] nums, int target) {
        // key 第 i 个位置
        // sub key 累加和 -> 结果
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();

        return f1(nums, target, 0, 0, dp);
    }

    public int f1(int[] nums, int target, int i, int sum, HashMap<Integer, HashMap<Integer, Integer>> dp) {

        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp.containsKey(i) && dp.get(i).containsKey(sum)) {
            return dp.get(i).get(sum);
        }

        int ans = f1(nums, target, i + 1, sum - nums[i], dp) + f1(nums, target, i + 1, sum + nums[i], dp);
        HashMap<Integer, Integer> map = dp.putIfAbsent(i, new HashMap<>());
        dp.get(i).put(sum, ans);

        return ans;
    }


    // 转化为01背包问题
    // 优化1:
    // 你可以认为nums中都是非负数
    // 因为即便是nums中有负数，比如[3,-4,2]
    // 因为你能在每个数前面用+或者-号
    // 所以[3,-4,2]其实和[3,4,2]达成一样的效果
    // 那么我们就全把nums变成非负数，不会影响结果的
    // 优化2:
    // 如果nums都是非负数，并且所有数的累加和是sum
    // 那么如果target>sum，很明显没有任何方法可以达到target，可以直接返回0
    // 优化3:
    // nums内部的数组，不管怎么+和-，最终的结果都一定不会改变奇偶性
    // 所以，如果所有数的累加和是sum，
    // 并且与target的奇偶性不一样，没有任何方法可以达到target，可以直接返回0
    // 优化4:
    // 比如说给定一个数组, nums = [1, 2, 3, 4, 5] 并且 target = 3
    // 其中一个方案是 : +1 -2 +3 -4 +5 = 3
    // 该方案中取了正的集合为P = {1，3，5}
    // 该方案中取了负的集合为N = {2，4}
    // 所以任何一种方案，都一定有 sum(P) - sum(N) = target
    // 现在我们来处理一下这个等式，把左右两边都加上sum(P) + sum(N)，那么就会变成如下：
    // sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
    // 2 * sum(P) = target + 数组所有数的累加和
    // sum(P) = (target + 数组所有数的累加和) / 2
    // 也就是说，任何一个集合，只要累加和是(target + 数组所有数的累加和) / 2
    // 那么就一定对应一种target的方式
    // 也就是说，比如非负数组nums，target = 7, 而所有数累加和是11
    // 求有多少方法组成7，其实就是求有多少种达到累加和(7+11)/2=9的方法
    // 优化5:
    // 二维动态规划的空间压缩技巧
    public int findTargetSumWays2(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || ((sum & 1) ^ (target & 1)) == 1) return 0;

        return f2(nums, (target + sum) >> 1);
    }

    // nums 中多少🀄️组合方式的累加和为 sum
    public int f2(int[] nums, int sum) {

        if (sum < 0) return 0;

        int[] dp = new int[sum + 1];
        // sum = 0,不选任何数有一种结果
        dp[0] = 1;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[sum];


    }


}
