package com.at.top200;

// https://leetcode.cn/problems/reverse-words-in-a-string/description/

public class _151_反转字符串中的单词 {

    public String reverseWords(String s) {

        s = s.trim();
        int r = s.length() - 1, l = r;
        StringBuilder res = new StringBuilder();

        while (l >= 0) {

            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }

            res.append(s.substring(l + 1, r + 1) + " ");

            while (l >= 0 && s.charAt(l) == ' ') {
                l--;
            }

            r = l;
        }

        return res.toString().trim();
    }
}
