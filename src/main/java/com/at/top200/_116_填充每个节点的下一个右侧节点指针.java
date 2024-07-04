package com.at.top200;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/


import com.at.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _116_填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();
                if (i < size - 1){
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
}
