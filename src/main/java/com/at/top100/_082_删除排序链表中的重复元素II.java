package com.at.top100;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/

import com.at.common.ListNode;

public class _082_删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode curr = newHead;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return newHead.next;
    }
}
