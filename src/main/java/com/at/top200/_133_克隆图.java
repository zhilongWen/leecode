package com.at.top200;

// https://leetcode.cn/problems/clone-graph/description/

import java.util.*;

public class _133_克隆图 {

    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    //--
    public Node cloneGraph2(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {

            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}