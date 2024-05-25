package com.at.algorithmzuo;

import com.at.common.TreeNode;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class KMP_002_572_另一棵树的子树 {

    // 方法1
    // 暴力递归
    // 时间复杂度O(n * m)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root != null && subRoot != null) {
            return same(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return subRoot == null;
    }

    public boolean same(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.val == b.val && same(a.left, b.left) && same(a.right, b.right);
        }

        return false;
    }

    // 方法2
    // 二叉树先序序列化 + KMP算法匹配
    // 时间复杂度O(n + m)
    public boolean isSubtree2(TreeNode t1, TreeNode t2) {

        if (t1 != null && t2 != null) {
            List<String> s1 = new ArrayList<>();
            List<String> s2 = new ArrayList<>();
            serial(t1, s1);
            serial(t2, s2);
            return kmp(s1, s2) != -1;
        }

        return t2 == null;
    }

    public void serial(TreeNode root, List<String> path) {

        if (root == null) {
            path.add(null);
        } else {
            path.add(String.valueOf(root.val));
            serial(root.left, path);
            serial(root.right, path);
        }
    }

    public int kmp(List<String> s1, List<String> s2) {

        int n = s1.size(), m = s2.size(), x = 0, y = 0;

        int[] next = next(s2, m);

        while (x < n && y < m) {
            if (equals(s1.get(x), s2.get(y))) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }

        return y == m ? x - y : -1;
    }

    public int[] next(List<String> arr, int m) {

        if (m == 1) {
            return new int[]{-1};
        }

        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;

        int i = 2, cn = 0;
        while (i < m) {
            if (equals(arr.get(i - 1), arr.get(cn))) {
                next[i++] = ++cn;
            } else {
                if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[i++] = 0;
                }
            }
        }

        return next;
    }

    public boolean equals(String a, String b) {

        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.equals(b);
        }

        return false;
    }
}
