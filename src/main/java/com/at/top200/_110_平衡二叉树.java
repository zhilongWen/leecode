package com.at.top200;

import com.at.common.TreeNode;

// https://leetcode.cn/problems/balanced-binary-tree/description/

public class _110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(h(root.left) - h(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int h(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(h(root.left), h(root.right)) + 1;
    }
}
