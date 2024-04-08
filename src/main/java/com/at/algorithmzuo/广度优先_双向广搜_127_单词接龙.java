package com.at.algorithmzuo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 广度优先_双向广搜_127_单词接龙 {

    public static void main(String[] args) {

        List<String> w = new ArrayList<>();
        // ["","","","","","",""]
        w.add("lest");
        w.add("leet");
        w.add("lose");
        w.add("code");
        w.add("lode");
        w.add("robe");
        w.add("lost");

        System.out.println(new 广度优先_双向广搜_127_单词接龙().ladderLength("leet", "code", w));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 词表
        Set<String> dict = new HashSet<>(wordList);

        // 目标不在词表中一定不存在
        if (!dict.contains(endWord)) return 0;

        // 少的一侧
        Set<String> smallLevel = new HashSet<>();
        // 多的一侧
        Set<String> bigLevel = new HashSet<>();

        // 扩出来的
        Set<String> nextLevel = new HashSet<>();

        smallLevel.add(beginWord);
        bigLevel.add(endWord);

        for (int i = 2; !smallLevel.isEmpty(); i++) {

            // 遍历少的一侧
            for (String word : smallLevel) {

                char[] words = word.toCharArray();

                for (int j = 0; j < words.length; j++) {

                    char old = words[j];

                    // 从 a-z 全部替换一遍
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (old != ch) {

                            words[j] = ch;
                            // 替换得到的新单词
                            String str = String.valueOf(words);
                            // 如果新单词在大的一侧，则直接返回
                            if (bigLevel.contains(str)) {
                                return i;
                            }

                            // 判断新单词是否在词表中，在才需要被处理
                            if (dict.contains(str)) {
                                // 从词表中删除，防止重复
                                dict.remove(str);
                                nextLevel.add(str);
                            }
                        }
                    }

                    words[j] = old;
                }
            }

            // 少的一侧处理完成后，让扩出来的与多的一侧比较看谁的多
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
