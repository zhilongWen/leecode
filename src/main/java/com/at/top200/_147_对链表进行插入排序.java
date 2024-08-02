package com.at.top200;

// https://leetcode.cn/problems/insertion-sort-list/description/

import com.at.common.ListNode;

public class _147_对链表进行插入排序 {

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode helper = new ListNode();
        ListNode curr = head;
        ListNode pre = helper;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;

            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;
            pre = helper;
            curr = next;
        }

        return helper.next;
    }
}
