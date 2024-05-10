package com.at.algorithmzuo;

//https://leetcode.cn/problems/add-two-numbers/description/
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

public class _002_两数相加 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode curr = node;

        int t = 0;

        while (l1 != null || l2 != null){

            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int v = a + b + t;

            t = v / 10;

            curr.next = new ListNode(v % 10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }

        if (t != 0) curr.next = new ListNode(t);

        return node.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
