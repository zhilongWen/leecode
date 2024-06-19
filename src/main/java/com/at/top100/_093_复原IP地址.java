package com.at.top100;

// https://leetcode.cn/problems/restore-ip-addresses/description/

import java.util.ArrayList;
import java.util.List;

public class _093_复原IP地址 {

    List<String> ans = new ArrayList<>();
    StringBuilder buffer = new StringBuilder();
    int len;

    public List<String> restoreIpAddresses(String s) {

        len = s.length();
        if (len < 4 || len > 12) {
            return ans;
        }

        f(s, 0, 0);

        return ans;
    }

    public void f(String str, int idx, int count) {

        if (len - idx > 3 * (4 - count)) {
            return;
        }

        if (idx == len) {
            if (count == 4) {
                ans.add(new String(buffer.substring(0, buffer.length() - 1)));
            }
            return;
        }

        if (idx > len || count == 4) {
            return;
        }

        StringBuilder tmp = new StringBuilder(buffer);

        // +1
        buffer.append(str.charAt(idx)).append(".");
        f(str, idx + 1, count + 1);

        if (str.charAt(idx) == '0') {
            return;
        }

        // +2
        if (idx + 1 < len) {
            buffer = new StringBuilder(tmp);
            buffer.append(str.substring(idx, idx + 2)).append(".");
            f(str, idx + 2, count + 1);
        }

        // +3
        if (idx + 2 < len) {
            buffer = new StringBuilder(tmp);
            int num = Integer.parseInt(str.substring(idx, idx + 3));
            if (num >= 0 && num <= 255) {
                buffer.append(str.substring(idx, idx + 3)).append(".");
                f(str, idx + 3, count + 1);
            }
        }
    }
}
