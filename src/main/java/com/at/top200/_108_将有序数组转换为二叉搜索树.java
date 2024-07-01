package com.at.top200;

import com.at.common.TreeNode;

// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/

public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    public TreeNode f(int[] num, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(num[mid]);

        root.left = f(num, left, mid - 1);
        root.right = f(num, mid + 1, right);

        return root;
    }
}
