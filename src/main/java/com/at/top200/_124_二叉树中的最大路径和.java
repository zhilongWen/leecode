package com.at.top200;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/


import com.at.common.TreeNode;

public class _124_二叉树中的最大路径和 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        f(root);

        return ans;
    }

    public int f(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(f(root.left), 0);
        int right = Math.max(f(root.right), 0);

        ans = Math.max(ans, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
