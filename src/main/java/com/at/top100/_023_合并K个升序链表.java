package com.at.top100;

// https://leetcode.cn/problems/merge-k-sorted-lists/

import com.at.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _023_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {

        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }

        int mid = l + ((r - l) >> 1);
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwo(ListNode a, ListNode b) {

        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode pre = head, aPre = a, bPre = b;

        while (aPre != null && bPre != null) {

            if (aPre.val < bPre.val) {
                pre.next = aPre;
                aPre = aPre.next;
            } else {
                pre.next = bPre;
                bPre = bPre.next;
            }
            pre = pre.next;
        }

        pre.next = aPre != null ? aPre : bPre;

        return head.next;
    }
}
