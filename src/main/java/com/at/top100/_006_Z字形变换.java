package com.at.top100;

// https://leetcode.cn/problems/zigzag-conversion/

import java.util.ArrayList;
import java.util.List;

public class _006_Z字形变换 {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuffer ans = new StringBuffer();
        list.forEach(ans::append);
        return ans.toString();
    }
}
