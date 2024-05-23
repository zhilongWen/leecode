package com.at.top100;

// https://leetcode.cn/problems/merge-two-sorted-lists/

import com.at.common.ListNode;

public class _021_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode ans = new ListNode(0);
        ListNode pre = ans;


        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;

        return ans.next;
    }
}
