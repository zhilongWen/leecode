package com.at.top100;

// https://leetcode.cn/problems/permutation-sequence/

import java.util.ArrayList;
import java.util.List;

public class _060_排列序列 {

    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        int f = 1;
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
            if (i != 0) {
                f *= i;
            }
        }
        f *= n;

        StringBuilder ans = new StringBuilder();
        k--;
        for (int i = n; i > 0; i--) {
            f /= list.size();
            int groupNum = k / f;
            Integer num = list.get(groupNum);
            list.remove(groupNum);
            k = k % f;
            ans.append(num);
        }

        return ans.toString();
    }
}
