package com.at.top100;

// https://leetcode.cn/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class _022_括号生成 {

    List<String> ans = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {

        this.n = n;
        f(new StringBuffer(), 0, 0);

        return ans;
    }

    public void f(StringBuffer buffer, int open, int close) {

        if (buffer.length() == n * 2) {
            ans.add(buffer.toString());
            return;
        }

        if (open < n) {
            buffer.append('(');
            f(buffer, open + 1, close);
            buffer.deleteCharAt(buffer.length() - 1);
        }

        if (close < open) {
            buffer.append(')');
            f(buffer, open, close + 1);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
