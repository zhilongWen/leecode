package com.at.top100;

// https://leetcode.cn/problems/simplify-path/

import java.util.Stack;

public class _071_简化路径 {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !".".equals(s)) {
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append("/").append(s);
        }

        return builder.isEmpty() ? "/" : builder.toString();
    }
}
