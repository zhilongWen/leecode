package com.at.top200;

import com.at.common.TreeNode;

import java.util.HashMap;

public class _105_从前序与中序遍历序列构造二叉树 {

    int[] preOrder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return f(0, 0, inorder.length - 1);
    }


    public TreeNode f(int root, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[root]);

        Integer idx = dic.get(preOrder[root]);
        node.left = f(root + 1, left, idx - 1);
        node.right = f(root + idx - left + 1, idx + 1, right);

        return node;
    }
}
