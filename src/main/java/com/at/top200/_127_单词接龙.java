package com.at.top200;

// https://leetcode.cn/problems/word-ladder/description/

import java.util.*;

public class _127_单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> smallLevel = new HashSet<>();
        Set<String> bigLevel = new HashSet<>();

        Set<String> nextLevel = new HashSet<>();

        smallLevel.add(beginWord);
        bigLevel.add(endWord);

        for (int i = 2; !smallLevel.isEmpty(); i++) {

            for (String word : smallLevel) {

                char[] words = word.toCharArray();
                for (int j = 0; j < words.length; j++) {

                    char old = words[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (old == ch) {
                            continue;
                        }

                        words[j] = ch;
                        String str = String.valueOf(words);
                        if (bigLevel.contains(str)) {
                            return i;
                        }

                        if (dict.contains(str)) {
                            dict.remove(str);
                            nextLevel.add(str);
                        }
                    }

                    words[j] = old;
                }
            }

            if (nextLevel.size() <= bigLevel.size()) {
                Set<String> tmp = smallLevel;
                smallLevel = nextLevel;
                nextLevel = tmp;
            } else {
                Set<String> tmp = smallLevel;
                smallLevel = bigLevel;
                bigLevel = nextLevel;
                nextLevel = tmp;
            }

            nextLevel.clear();
        }

        return 0;
    }
}
