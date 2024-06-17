package com.at.top100;

// https://leetcode.cn/problems/partition-list/description/

import com.at.common.ListNode;

public class _086_分隔链表 {

    public ListNode partition(ListNode head, int x) {

        ListNode maxHead = new ListNode(0);
        ListNode minHead = new ListNode(0, head);

        ListNode a = maxHead, b = minHead;

        while (b.next != null) {

            ListNode curr = b.next;
            if (curr.val >= x) {
                a.next = curr;
                a = a.next;
                b.next = curr.next;
            } else {
                b = curr;
            }
        }


        a.next = null;
        b.next = maxHead.next;

        return minHead.next;
    }
}
