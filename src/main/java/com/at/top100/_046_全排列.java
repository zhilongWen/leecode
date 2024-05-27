package com.at.top100;

// https://leetcode.cn/problems/permutations/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _046_全排列 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return ans;
        }

        for (int num : nums) {
            buffer.add(num);
        }

        dfs(0);
        return ans;
    }

    public void dfs(int idx) {

        if (idx == buffer.size() - 1) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = idx; i < buffer.size(); i++) {

            Collections.swap(buffer, idx, i);
            dfs(idx + 1);
            Collections.swap(buffer, idx, i);

        }
    }
}
