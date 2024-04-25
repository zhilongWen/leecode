package com.at.algorithmzuo;


// https://leetcode.cn/problems/predict-the-winner/description/


public class 动态规划_013_区间dp_486_预测赢家 {

    public boolean predictTheWinner(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int first = f1(nums, 0, nums.length - 1);

        return first >= sum - first;

    }

    // nums[l...r]范围上的数字进行游戏，轮到玩家1
    // 返回玩家1最终能获得多少分数，玩家1和玩家2都绝顶聪明
    public int f1(int[] nums, int l, int r) {

        if (l == r) {
            return nums[l];
        }

        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }

        //选 l
        int p1 = nums[l] + Math.min(f1(nums, l + 2, r), f1(nums, l + 1, r - 1));
        int p2 = nums[r] + Math.min(f1(nums, l, r - 2), f1(nums, l + 1, r - 1));

        return Math.max(p1, p2);

    }


    // 记忆化搜索
    public boolean predictTheWinner2(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }


        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int first = f2(nums, 0, n - 1, dp);

        return first >= sum - first;


    }

    public int f2(int[] nums, int l, int r, int[][] dp) {

        if (dp[l][r] != -1) return dp[l][r];

        int ans;
        if (l == r) {
            ans = nums[l];
        } else if (l + 1 == r) {
            ans = Math.max(nums[l], nums[r]);
        } else {

            int p1 = nums[l] + Math.min(f2(nums, l + 2, r, dp), f2(nums, l + 1, r - 1, dp));
            int p2 = nums[r] + Math.min(f2(nums, l + 1, r - 1, dp), f2(nums, l, r - 2, dp));

            ans = Math.max(p1, p2);
        }

        dp[l][r] = ans;
        return ans;

    }


}
