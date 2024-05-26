package com.at.top100;


// https://leetcode.cn/problems/combination-sum/

import java.util.ArrayList;
import java.util.List;

public class _039_组合总和 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buf = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return ans;
    }

    public void dfs(int[] arr, int idx, int target) {

        if (idx == arr.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(buf));
            return;
        }

        dfs(arr, idx + 1, target);

        if (target - arr[idx] >= 0) {
            buf.add(arr[idx]);
            dfs(arr, idx, target - arr[idx]);
            buf.remove(buf.size() - 1);
        }
    }
}
