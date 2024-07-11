package com.at.top200;

// https://leetcode.cn/problems/valid-palindrome/description/


public class _125_验证回文串 {

    public boolean isPalindrome(String s) {

        int n = s.length();
        int left = 0, right = n - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
