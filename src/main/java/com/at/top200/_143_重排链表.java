package com.at.top200;

// https://leetcode.cn/problems/reorder-list/description/

import com.at.common.ListNode;

public class _143_重排链表 {

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        l2 = reverse(l2);

        merge(l1, l2);
    }

    public void merge(ListNode l1, ListNode l2) {

        ListNode tmp1 = null, tmp2 = null;

        while (l1 != null && l2 != null) {

            tmp1 = l1.next;
            tmp2 = l2.next;

            l1.next = l2;
            l1 = tmp1;

            l2.next = l1;
            l2 = tmp2;
        }
    }

    public ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public ListNode findMid(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
