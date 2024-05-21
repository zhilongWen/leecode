package com.at.top100;

import com.at.common.ListNode;

public class _002_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode curr = node;

        int v = 0;
        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int t = v + x + y;
            v = t / 10;

            curr.next = new ListNode(t % 10);
            curr = curr.next;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

        }

        if (v != 0) curr.next = new ListNode(v);

        return node.next;
    }
}
