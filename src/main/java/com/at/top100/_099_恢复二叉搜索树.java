package com.at.top100;

// https://leetcode.cn/problems/recover-binary-search-tree/description/

import com.at.common.TreeNode;

public class _099_恢复二叉搜索树 {

    TreeNode a = null, b = null, last = null;

    public void recoverTree(TreeNode root) {

        f(root);

        int v = a.val;
        a.val = b.val;
        b.val = v;
    }

    public void f(TreeNode root) {

        if (root == null) {
            return;
        }

        f(root.left);

        if (last != null && last.val > root.val) {
            if (a == null) {
                a = last;
            }
            b = root;
        }

        last = root;

        f(root.right);
    }
}
