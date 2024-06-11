package com.at.top100;

// https://leetcode.cn/problems/subsets/description/

import java.util.ArrayList;
import java.util.List;

public class _078_子集 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        f(nums, 0);

        return ans;
    }

    public void f(int[] arr, int i) {

        if (i == arr.length) {
            ans.add(new ArrayList<>(buffer));
            return;
        }

        f(arr, i + 1);

        buffer.add(arr[i]);
        f(arr, i + 1);
        buffer.remove(buffer.size() - 1);
    }
}
