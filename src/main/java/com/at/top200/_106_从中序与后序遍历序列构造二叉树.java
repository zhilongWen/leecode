package com.at.top200;

import com.at.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {

    int idx;
    int[] postOrder;
    int[] inOrder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postOrder = postorder;
        this.inOrder = inorder;
        idx = postorder.length - 1;

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inorder[i], i);
        }

        return f(0, inorder.length - 1);
    }

    public TreeNode f(int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = postOrder[idx];
        TreeNode root = new TreeNode(rootVal);

        // 根据 root 所在位置分成左右两棵子树
        Integer index = map.get(rootVal);

        idx--;

        root.right = f(index + 1, right);
        root.left = f(left, index - 1);

        return root;
    }
}
