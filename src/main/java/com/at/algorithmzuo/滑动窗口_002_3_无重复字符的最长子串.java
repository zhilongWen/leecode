package com.at.algorithmzuo;


// 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/

import java.util.Arrays;

public class 滑动窗口_002_3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        // char -> 0 ~ 255
        // 当前字符上一次出现的位置
        int[] last = new int[256];
        Arrays.fill(last, -1);

        int ans = 0;
        for (int l = 0, r = 0; r < chars.length; r++) {

            // 当前字符上一次出现的位置,和当前位置比较，看那个大
            // a .... bcdfa
            //        l   r   l 已经走过了 a 之前的位置
            // -->
            // a .... bcdfa
            // l          r   l 还在 a 之前位置上
            l = Math.max(l,last[chars[r]] + 1);

            ans = Math.max(ans,r - l + 1);

            // 更新当前字符的位置
            last[chars[r]] = r;
        }

        return ans;

    }

}
