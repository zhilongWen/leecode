package com.at.top200;

// https://leetcode.cn/problems/linked-list-cycle-ii/description/

import com.at.common.ListNode;

public class _142_环形链表II {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
