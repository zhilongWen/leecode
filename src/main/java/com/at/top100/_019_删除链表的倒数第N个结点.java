package com.at.top100;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

import com.at.common.ListNode;

public class _019_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode ans = new ListNode(0,head);
        ListNode f = head;
        ListNode s = ans;

        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f != null){
            f = f.next;
            s = s.next;
        }

        s.next = s.next.next;

        return ans.next;
    }
}
