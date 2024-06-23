package com.at.top100;

// https://leetcode.cn/problems/validate-binary-search-tree/

import com.at.common.TreeNode;

public class _098_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean f(TreeNode root, long low, long up) {

        if (root == null) {
            return true;
        }

        if (root.val <= low || root.val >= up) {
            return false;
        }

        return f(root.left, low, root.val) && f(root.right, root.val, up);
    }
}
