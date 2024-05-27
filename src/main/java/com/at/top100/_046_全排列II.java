package com.at.top100;

// https://leetcode.cn/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _046_全排列II {

    boolean[] visited;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);

        return ans;
    }

    public void dfs(int[] arr, int idx) {

        if (idx == arr.length) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i] || (i > 0 && arr[i] == arr[i - 1]) && !visited[i - 1]) {
                continue;
            }

            buffer.add(arr[i]);
            visited[i] = true;
            dfs(arr, idx + 1);
            visited[i] = false;
            buffer.remove(idx);
        }
    }
}
