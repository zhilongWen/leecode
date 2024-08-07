package com.at.top200;

import com.at.common.TreeNode;

// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/

public class _114_二叉树展开为链表 {

    public void flatten(TreeNode root) {

        while (root != null) {

            if (root.left == null) {
                root = root.right;
            } else {

                TreeNode pre = root.left;

                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }
    }
}
