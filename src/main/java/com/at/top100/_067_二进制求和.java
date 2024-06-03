package com.at.top100;

// https://leetcode.cn/problems/add-binary/description/

public class _067_二进制求和 {

    public String addBinary(String a, String b) {

        StringBuilder ans = new StringBuilder();

        int m = a.length() - 1, n = b.length() - 1;
        int sum = 0;
        while (m >= 0 || n >= 0) {

            int i = m < 0 ? 0 : a.charAt(m) - '0';
            int j = n < 0 ? 0 : b.charAt(n) - '0';

            int k = sum + i + j;
            if (k == 0) {
                ans.append("0");
            } else if (k == 1) {
                ans.append("1");
            } else if (k == 2) {
                ans.append("0");
                sum = 1;
            } else if (k == 3) {
                ans.append("1");
                sum = 1;
            }
            n--;
            m--;
        }

        if (sum != 0) {
            ans.append(sum);
        }

        return ans.reverse().toString();
    }
}
