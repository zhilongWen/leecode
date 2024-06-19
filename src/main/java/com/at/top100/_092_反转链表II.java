package com.at.top100;

// https://leetcode.cn/problems/reverse-linked-list-ii/description/

import com.at.common.ListNode;

public class _092_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return newHead.next;
    }
}
