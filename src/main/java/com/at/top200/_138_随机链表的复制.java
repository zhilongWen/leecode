//package com.at.top200;
//
//// https://leetcode.cn/problems/copy-list-with-random-pointer/description/
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class _138_随机链表的复制 {
//
//    public Node copyRandomList(Node head) {
//
//        if (head == null){
//            return null;
//        }
//
//        Node curr = head;
//        Map<Node,Node> map = new HashMap<>();
//
//        while (curr != null){
//            map.put(curr,new Node(curr.val));
//            curr = curr.next;
//        }
//
//        curr = head;
//
//        while (curr != null){
//            map.get(curr).next = map.get(curr.next);
//            map.get(curr).random = map.get(curr.random);
//            curr = curr.next;
//        }
//
//        return map.get(head);
//    }
//}
//
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
