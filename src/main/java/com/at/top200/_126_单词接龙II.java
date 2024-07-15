package com.at.top200;

// https://leetcode.cn/problems/word-ladder-ii/

import java.util.*;

public class _126_单词接龙II {

    Set<String> dict;
    Set<String> currLevel = new HashSet<>();
    Set<String> nextLevel = new HashSet<>();

    Map<String, List<String>> graph = new HashMap<>();

    LinkedList<String> path = new LinkedList<>();

    List<List<String>> ans = new ArrayList<>();

    public void build(List<String> wordList) {
        dict = new HashSet<>(wordList);
        currLevel.clear();
        nextLevel.clear();
        graph.clear();
        path.clear();
        ans.clear();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        build(wordList);

        if (!dict.contains(endWord)) {
            return ans;
        }


        if (bfs(beginWord, endWord)) {
            dfs(endWord, beginWord);
        }
        return ans;
    }

    public boolean bfs(String begin, String end) {

        boolean find = false;
        currLevel.add(begin);

        while (!currLevel.isEmpty()) {

            dict.removeAll(currLevel);
            for (String word : currLevel) {

                char[] w = word.toCharArray();
                for (int i = 0; i < w.length; i++) {

                    char old = w[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        w[i] = ch;
                        String str = String.valueOf(w);
                        if (dict.contains(str) && !str.equals(word)) {
                            if (str.equals(end)) {
                                find = true;
                            }
                            graph.putIfAbsent(str, new ArrayList<>());
                            graph.get(str).add(word);
                            nextLevel.add(str);
                        }
                    }

                    w[i] = old;
                }
            }

            if (find) {
                return true;
            } else {
                // 继续寻找从下一行寻找
                Set<String> tmp = currLevel;
                currLevel = nextLevel;
                nextLevel = tmp;
                nextLevel.clear();
            }
        }

        return false;
    }

    public void dfs(String word, String aim) {

        path.addFirst(word);
        if (word.equals(aim)) {
            ans.add(new ArrayList<>(path));
        } else if (graph.containsKey(word)) {
            for (String next : graph.get(word)) {
                dfs(next, aim);
            }
        }

        path.removeFirst();
    }
}
