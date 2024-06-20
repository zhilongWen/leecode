package com.at.top100;

// https://leetcode.cn/problems/binary-tree-inorder-traversal/description/

import com.at.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _095_不同的二叉搜索树II {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        return f(1, n);
    }

    public List<TreeNode> f(int idx, int n) {

        List<TreeNode> ans = new LinkedList<TreeNode>();

        if (idx > n) {
            ans.add(null);
            return ans;
        }

        for (int i = idx; i <= n; i++) {

            List<TreeNode> left = f(idx, i - 1);

            List<TreeNode> right = f(i + 1, n);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    ans.add(curr);
                }
            }
        }

        return ans;
    }
}
