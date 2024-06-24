package com.at.top200;

import com.at.common.TreeNode;

public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return f(root.left, root.right);
    }

    public boolean f(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return f(left.left, right.right) && f(left.right, right.left);
    }
}
