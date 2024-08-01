package com.at.top200;

// https://leetcode.cn/problems/binary-tree-postorder-traversal/description/

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _145_二叉树的后序遍历 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        post(root);

        return ans;
    }

    public void post(TreeNode root) {

        if (root == null) {
            return;
        }

        post(root.left);
        post(root.right);

        ans.add(root.val);
    }
}
