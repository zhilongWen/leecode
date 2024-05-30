package com.at.top100;

// https://leetcode.cn/problems/rotate-list/description/

import com.at.common.ListNode;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class _061_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode pre = head;
        while (pre.next != null) {
            pre = pre.next;
            n++;
        }

        k = n - k % n;
        if (k == n) {
            return head;
        }
        pre.next = head;
        while (k-- > 0) {
            pre = pre.next;
        }

        ListNode node = pre.next;
        pre.next = null;

        return node;
    }
}
