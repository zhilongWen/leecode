package com.at.top100;

// https://leetcode.cn/problems/swap-nodes-in-pairs/

import com.at.common.ListNode;

public class _024_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next = head;

        return tmp;
    }
}
