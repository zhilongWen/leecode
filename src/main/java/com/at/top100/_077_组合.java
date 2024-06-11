package com.at.top100;

// https://leetcode.cn/problems/combinations/description/

import java.util.ArrayList;
import java.util.List;

public class _077_组合 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        f(n, k, 1);
        return ans;
    }

    public void f(int n, int k, int s) {

        if (k == 0) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = s; i <= n - k + 1; i++) {
            buffer.add(i);
            f(n, k - 1, i + 1);
            buffer.remove(buffer.size() - 1);
        }
    }
}
