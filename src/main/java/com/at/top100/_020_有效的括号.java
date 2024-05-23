package com.at.top100;

// https://leetcode.cn/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _020_有效的括号 {

    public boolean isValid(String s) {

        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.empty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
