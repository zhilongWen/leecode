package com.at.top200;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/description/

import com.at.common.ListNode;

public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pB != pA) {

            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
