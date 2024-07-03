package com.at.top200;

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/path-sum-ii/description/

public class _113_路径总和II {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        f(root, targetSum);
        return ans;
    }

    public void f(TreeNode root, int targetSum) {

        if (root == null) {
            return;
        }

        buffer.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(buffer));
        }

        f(root.left, targetSum);
        f(root.right, targetSum);

        buffer.remove(buffer.size() - 1);
    }
}
