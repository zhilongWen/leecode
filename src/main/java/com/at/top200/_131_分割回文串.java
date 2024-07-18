package com.at.top200;

// https://leetcode.cn/problems/surrounded-regions/

import java.util.*;

public class _131_分割回文串 {

    List<List<String>> ans = new ArrayList<>();
    Deque<String> queue = new LinkedList<>();

    String str;

    public List<List<String>> partition(String s) {

        this.str = s;
        f(0);

        return ans;
    }

    public void f(int idx) {

        if (idx >= str.length()) {
            ans.add(new ArrayList<>(queue));
            return;
        }

        for (int i = idx; i < str.length(); i++) {

            if (!isPalindrome(idx, i)) {
                continue;
            }

            String s = str.substring(idx, i + 1);
            queue.addLast(s);

            f(i + 1);
            queue.removeLast();
        }
    }

    public boolean isPalindrome(int l, int r) {

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
