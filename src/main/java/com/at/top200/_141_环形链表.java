package com.at.top200;

// https://leetcode.cn/problems/linked-list-cycle/description/

import com.at.common.ListNode;

public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
