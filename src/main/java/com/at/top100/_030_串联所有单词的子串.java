package com.at.top100;


// https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _030_串联所有单词的子串 {

    public List<Integer> findSubstring1(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();

        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }

        for (int j = 0; j < wordLen; j++) {

            Map<String, Integer> map = new HashMap<>();
            int num = 0;

            for (int i = j; i < s.length() - wordNum * wordLen + 1; i += wordLen) {

                boolean hasRemove = false;
                while (num < wordNum) {

                    String w = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(w)) {
                        map.put(w, map.getOrDefault(w, 0) + 1);
                        if (map.get(w) > allWords.get(w)) {
                            // 删除多余的
                            hasRemove = true;
                            int removeNum = 0;

                            while (map.get(w) > allWords.get(w)) {
                                String removeW = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                map.put(removeW, map.get(removeW) - 1);
                                removeNum++;
                            }

                            num = num - removeNum + 1;
                            i = i + (removeNum - 1) * wordLen;
                            break;
                        }
                    } else {
                        map.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }

                if (num == wordNum) {
                    res.add(i);
                }
                if (num > 0 && !hasRemove) {
                    String w = s.substring(i, i + wordLen);
                    map.put(w, map.get(w) - 1);
                    num -= 1;
                }
            }

        }

        return res;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();

        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {

            Map<String, Integer> map = new HashMap<>();
            int num = 0;
            while (num < wordNum) {

                String w = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(w)) {
                    map.put(w, map.getOrDefault(w, 0) + 1);
                    if (map.get(w) > allWords.get(w)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }

            if (num == wordNum) {
                res.add(i);
            }
        }

        return res;
    }
}
