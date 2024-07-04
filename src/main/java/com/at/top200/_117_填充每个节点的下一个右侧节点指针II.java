package com.at.top200;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/


import com.at.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _117_填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            Node last = null;

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i != 1) {
                    last.next = node;
                }

                last = node;
            }
        }

        return root;
    }
}
