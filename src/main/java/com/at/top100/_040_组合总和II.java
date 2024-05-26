package com.at.top100;

// https://leetcode.cn/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040_组合总和II {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buf = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    public void dfs(int[] arr, int idx, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(buf));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            if (arr[i] > target) {
                break;
            }
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }

            buf.add(arr[i]);
            dfs(arr, i + 1, target - arr[i]);
            buf.remove(buf.size() - 1);
        }
    }
}
