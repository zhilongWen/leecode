package com.at.top200;

// https://leetcode.cn/problems/pascals-triangle-ii/description/


import java.util.ArrayList;
import java.util.List;

public class _119_杨辉三角II {

    public List<Integer> getRow(int numRows) {

        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 1; i <= numRows; i++) {

            ans.add(0);
            for (int j = i; j > -0; j--) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
        }

        return ans;
    }
}
