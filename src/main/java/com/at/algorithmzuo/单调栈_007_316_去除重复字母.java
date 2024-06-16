package com.at.algorithmzuo;

// https://leetcode.cn/problems/remove-duplicate-letters/description/

public class 单调栈_007_316_去除重复字母 {

    public String removeDuplicateLetters(String s) {

        int n = s.length();
        char[] stack = new char[n];
        int[] cnts = new int[26];
        boolean[] entry = new boolean[26];
        int r = 0;

        char[] arr = s.toCharArray();

        for (char c : arr) {
            cnts[c - 'a']++;
        }

        for (char curr : arr) {

            if (!entry[curr - 'a']) {

                // 从左往右依次遍历字符，a -> 0 b -> 1 ... z -> 25
                // cur -> cur - 'a'
                while (r > 0 && curr < stack[r - 1] && cnts[stack[r - 1] - 'a'] > 0) {
                    entry[stack[r - 1] - 'a'] = false;
                    r--;
                }

                stack[r++] = curr;
                entry[curr - 'a'] = true;
            }

            cnts[curr - 'a']--;
        }


        return String.valueOf(stack, 0, r);
    }
}
