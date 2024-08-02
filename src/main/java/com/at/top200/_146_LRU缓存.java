package com.at.top200;

// https://leetcode.cn/problems/lru-cache/description/

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存 {

    class LRUCache {

        class Node {

            int key;
            int value;
            Node prev, next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, Node> cache = new HashMap<>();

        private int capacity;
        private int size;
        private Node head, tail;

        public LRUCache(int capacity) {

            this.capacity = capacity;
            this.size = 0;
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addHead(Node node) {
            node.prev = head;
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
        }

        private Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

        public int get(int key) {

            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }

            removeNode(node);
            addHead(node);

            return node.value;
        }

        public void put(int key, int value) {

            Node node = cache.get(key);

            if (node != null) {
                node.value = value;
                removeNode(node);
                addHead(node);
                return;
            }

            node = new Node(key, value);

            cache.put(key, node);
            addHead(node);

            ++size;
            if (size <= capacity) {
                return;
            }

            Node tailNode = removeTail();
            cache.remove(tailNode.key);
            --size;
        }
    }
}
