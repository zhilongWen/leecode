package com.at.top100;

// https://leetcode.cn/problems/palindrome-number/description/

public class _009_回文数 {

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        char[] arr = String.valueOf(x).toCharArray();

        int len = arr.length;
        if (len == 1) return true;

        int l = 0, r = len - 1;

        while (l < r) {
            if (arr[l++] != arr[r--]) return false;
        }

        return true;
    }
}
