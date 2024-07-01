package com.at.top200;

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/submissions/543312201/

public class _107_二叉树的层序遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> buffer = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                buffer.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(0, buffer);
        }

        return ans;
    }
}
