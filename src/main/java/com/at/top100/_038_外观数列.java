package com.at.top100;


// https://leetcode.cn/problems/count-and-say/

public class _038_外观数列 {

    public String countAndSay(int n) {

        String ans = "1";
        if (n == 1) {
            return ans;
        }
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            for (int l = 0, r = 0; r < ans.length(); ) {

                while (r < ans.length() && ans.charAt(l) == ans.charAt(r)) {
                    r++;
                }
                buffer.append((char) (r - l + '0'));
                buffer.append(ans.charAt(l));
                l = r;
            }

            ans = buffer.toString();
            buffer.delete(0, buffer.length());
        }

        return ans;
    }
}
