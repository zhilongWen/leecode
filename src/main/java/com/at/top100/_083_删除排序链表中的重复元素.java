package com.at.top100;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/

import com.at.common.ListNode;

public class _083_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, pre = head.next;
        while (pre != null) {
            if (pre.val != curr.val) {
                curr.next = pre;
                curr = curr.next;
            }
            pre = pre.next;
        }

        curr.next = null;

        return head;
    }
}
