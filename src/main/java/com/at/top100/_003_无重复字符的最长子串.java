package com.at.top100;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

import java.util.Arrays;

public class _003_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {

        char[] arr = s.toCharArray();

        int[] cnts = new int[256];
        Arrays.fill(cnts, -1);

        int ans = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            l = Math.max(l, cnts[arr[r]] + 1);
            ans = Math.max(ans, r - l + 1);

            cnts[arr[r]] = r;
        }

        return ans;
    }
}
