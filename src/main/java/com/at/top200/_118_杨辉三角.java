package com.at.top200;

// https://leetcode.cn/problems/pascals-triangle/description/


import java.util.ArrayList;
import java.util.List;

public class _118_杨辉三角 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.clear();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }

            ans.add(new ArrayList<>(row));
        }

        return ans;
    }
}
