package com.at.top100;

// https://leetcode.cn/problems/text-justification/description/

import java.util.ArrayList;
import java.util.List;

public class _068_文本左右对齐 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        int currentLen = 0, start = 0, end = 0;

        for (int i = 0; i < words.length; ) {

            if (currentLen == 0 && currentLen + words[i].length() <= maxWidth
                    || currentLen > 0 && currentLen + 1 + words[i].length() <= maxWidth) {
                end++;
                if (currentLen == 0) {
                    currentLen = currentLen + words[i].length();
                } else {
                    currentLen = currentLen + words[i].length() + 1;
                }
                i++;
            } else {
                int sub = maxWidth - currentLen + (end - start) - 1;
                if (end - start == 1) {
                    ans.add(words[start] + getStringBlank(sub));
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append(words[start]);
                    int avgBank = sub / ((end - start) - 1);
                    int miss = sub - avgBank * ((end - start) - 1);
                    String bank = getStringBlank(avgBank + 1);
                    int k = 1;
                    for (int j = 0; j < miss; j++) {
                        builder.append(bank).append(words[start + k]);
                        k++;
                    }
                    bank = getStringBlank(avgBank);
                    for (; k < (end - start); k++) {
                        builder.append(bank).append(words[start + k]);
                    }
                    ans.add(builder.toString());
                }
                start = end;
                currentLen = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(words[start]);
        for (int i = 1; i < (end - start); i++) {
            builder.append(" ").append(words[start + i]);
        }
        builder.append(getStringBlank(maxWidth - currentLen));
        ans.add(builder.toString());

        return ans;
    }

    //得到 n 个空白
    private String getStringBlank(int n) {
        return " ".repeat(Math.max(0, n));
    }
}
