package com.at.top200;

// https://leetcode.cn/problems/longest-consecutive-sequence/description/

import com.at.common.TreeNode;

public class _129_求根节点到叶节点数字之和 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {

        if (root == null) {
            return 0;
        }

        int sum = preSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
