package com.at.top200;

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            List<Integer> buffer = new ArrayList<>(queueSize);

            for (int i = 0; i < queueSize; i++) {

                TreeNode node = queue.poll();

                if (flag) {
                    buffer.add(node.val);
                } else {
                    buffer.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(buffer);
            flag = !flag;
        }

        return ans;
    }
}
