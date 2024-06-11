package com.at.top100;

// https://leetcode.cn/problems/minimum-window-substring/description/

public class _076_最小覆盖子串 {

    public String minWindow(String s, String t) {

        int tLen = t.length();
        int sLen = s.length();
        if (tLen > sLen) {
            return "";
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] cnts = new int[256];
        for (char c : tArr) {
            cnts[c]--;
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int l = 0, r = 0, debt = tLen; r < sLen; r++) {

            if (cnts[sArr[r]]++ < 0) {
                debt--;
            }

            if (debt == 0) {

                while (cnts[sArr[l]] > 0) {
                    cnts[sArr[l++]]--;
                }

                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
