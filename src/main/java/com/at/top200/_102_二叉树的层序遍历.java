package com.at.top200;

import com.at.common.TreeNode;

import java.util.*;

public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            List<Integer> buffer = new ArrayList<>(queueSize);

            for (int i = 0; i < queueSize; i++) {

                TreeNode node = queue.poll();
                buffer.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(buffer);
        }

        return ans;
    }
}
