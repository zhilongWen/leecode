package com.at.top200;

import com.at.common.TreeNode;

// https://leetcode.cn/problems/path-sum/description/

public class _112_路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
