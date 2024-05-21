package com.at.top100;

// https://leetcode.cn/problems/longest-palindromic-substring/description/

public class _005_最长回文子串 {

    public String longestPalindrome(String s) {

        int len = s.length();
        String ans = "";

        for (int i = 0, r = 0, l = 0; i < len; ) {

            if (len - i <= ans.length() / 2) break;

            l = i;
            r = i;
            while (r + 1 < len && s.charAt(i) == s.charAt(r + 1)) {
                r++;
            }

            i = r + 1;
            while (l - 1 >= 0 && r + 1 < len && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }

            if (ans.length() < r - l + 1) {
                ans = s.substring(l, r + 1);
            }
        }

        return ans;
    }
}
