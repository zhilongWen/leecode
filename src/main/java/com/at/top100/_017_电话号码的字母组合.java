package com.at.top100;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/

import java.util.*;

public class _017_电话号码的字母组合 {

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> ans = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return ans;

        f(digits, 0, new StringBuffer());

        return ans;
    }

    public void f(String digits, int idx, StringBuffer buffer) {

        if (idx == digits.length()) {
            ans.add(buffer.toString());
        } else {
            String s = phoneMap.get(digits.charAt(idx));
            int len = s.length();

            for (int i = 0; i < len; i++) {
                buffer.append(s.charAt(i));
                f(digits, idx + 1, buffer);
                buffer.deleteCharAt(idx);
            }
        }
    }
}
