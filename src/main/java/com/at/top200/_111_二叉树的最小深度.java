package com.at.top200;

import com.at.common.TreeNode;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/

public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDep = Integer.MAX_VALUE;
        if (root.left != null) {
            minDep = Math.min(minDepth(root.left), minDep);
        }
        if (root.right != null) {
            minDep = Math.min(minDepth(root.right), minDep);
        }

        return minDep + 1;
    }
}
