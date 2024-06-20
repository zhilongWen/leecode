package com.at.top100;

// https://leetcode.cn/problems/binary-tree-inorder-traversal/description/

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _094_二叉树的中序遍历 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        f(root);

        return ans;
    }

    public void f(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            f(root.left);
        }

        ans.add(root.val);

        if (root.right != null) {
            f(root.right);
        }
    }
}
