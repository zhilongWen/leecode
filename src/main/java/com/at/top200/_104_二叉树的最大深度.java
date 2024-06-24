package com.at.top200;

import com.at.common.TreeNode;

public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        return f(root);
    }

    public int f(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(f(root.left), f(root.right));
    }
}
