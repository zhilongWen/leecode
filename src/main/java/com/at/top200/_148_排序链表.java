package com.at.top200;

// https://leetcode.cn/problems/sort-list/description/

import com.at.common.ListNode;

public class _148_排序链表 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode();
        ListNode res = h;

        while (left != null && right != null) {

            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;

        return res.next;
    }
}
