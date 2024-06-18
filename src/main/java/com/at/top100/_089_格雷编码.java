package com.at.top100;

// https://leetcode.cn/problems/gray-code/description/

import java.util.ArrayList;
import java.util.List;

public class _089_格雷编码 {

    public List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();

        ans.add(0);
        for (int i = 0; i < n; i++) {

            int add = 1 << i;
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) + add);
            }
        }

        return ans;
    }
}
