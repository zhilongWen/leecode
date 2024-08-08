package com.at.top200;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/

import java.util.Stack;

public class _150_逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
