package com.at.top100;

// https://leetcode.cn/problems/length-of-last-word/description/

public class _058_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {

        int idx = s.length() - 1;
        while (s.charAt(idx) == ' ') {
            idx--;
        }

        int ans = 0;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            ans++;
            idx--;
        }

        return ans;
    }
}
