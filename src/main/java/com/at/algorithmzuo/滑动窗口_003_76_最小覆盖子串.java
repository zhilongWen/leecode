package com.at.algorithmzuo;


// 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 测试链接 : https://leetcode.cn/problems/minimum-window-substring/


import java.util.Arrays;

public class 滑动窗口_003_76_最小覆盖子串 {


    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) return "";

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] cnts = new int[256];
        for (char c : tArr) {
            cnts[c]--;
        }

        // 从哪个位置开头，发现的这个最小覆盖子串
        int start = 0;
        // 最小覆盖子串的长度
        int len = Integer.MAX_VALUE;

        for (int l = 0, r = 0, debt = tLen; r < sLen; r++) {

            // s[r] 当前字符 -> int
            // cnts[s[r]] : 当前字符欠债情况，负数就是欠债，正数就是多给的
            if (cnts[sArr[r]]++ < 0) {
                // 目标数据
                debt--;
            }

            if (debt == 0) {

                // 尝试缩小窗口
                // r位置结尾，真的有覆盖子串！
                // 看看这个覆盖子串能不能尽量短
                while (cnts[sArr[l]] > 0) {
                    cnts[sArr[l++]]--;
                }

                // 从while里面出来，
                // l....r就是r位置结尾的最小覆盖子串
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }


}
