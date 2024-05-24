package com.at.top100;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/

import com.at.common.ListNode;

public class _025_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, end = newHead;

        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }

        return newHead.next;
    }

    public ListNode reverse(ListNode node) {

        ListNode pre = null, curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
