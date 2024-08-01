package com.at.top200;

// https://leetcode.cn/problems/binary-tree-preorder-traversal/description/

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _144_二叉树的前序遍历 {

    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {

        res = new ArrayList<>();

        pre(root);

        return res;
    }

    public void pre(TreeNode root) {

        if (root == null) {
            return;
        }

        res.add(root.val);

        pre(root.left);
        pre(root.right);
    }
}
