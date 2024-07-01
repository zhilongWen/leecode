package com.at.top200;

import com.at.common.ListNode;
import com.at.common.TreeNode;

// https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/

public class _109_有序链表转换二叉搜索树 {

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {

        this.head = head;

        return f(0, getLen(head) - 1);
    }

    public int getLen(ListNode head) {

        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public TreeNode f(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) >> 1;
        TreeNode root = new TreeNode(head.val);

        root.left = f(left, mid - 1);
        root.val = head.val;
        head = head.next;
        root.right = f(mid + 1, right);

        return root;
    }
}
