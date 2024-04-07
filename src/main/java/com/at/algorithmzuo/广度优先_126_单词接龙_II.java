package com.at.algorithmzuo;

import java.util.*;

public class 广度优先_126_单词接龙_II {

    public static void main(String[] args) {

        List<String> w = new ArrayList<>();
        w.add("hot");
        w.add("dot");
        w.add("dog");
        w.add("lot");
        w.add("log");
        w.add("cog");

        List<List<String>> ladders = new 广度优先_126_单词接龙_II().findLadders("hit", "cog", w);

        System.out.println(ladders);

    }


    // 单词表
    static Set<String> dict;

    static Set<String> curLevel = new HashSet<>();
    static Set<String> nextLevel = new HashSet<>();

    // 反向图
    static HashMap<String, ArrayList<String>> graph = new HashMap<>();

    // 记录路径，当生成一条有效路的时候，拷贝进ans
    static LinkedList<String> path = new LinkedList<>();

    static List<List<String>> ans = new ArrayList<>();


    public void build(List<String> wordLis) {
        dict = new HashSet<>(wordLis);
        curLevel.clear();
        nextLevel.clear();
        graph.clear();
        path.clear();
        ans.clear();
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        build(wordList);

        if (!dict.contains(endWord)) return ans;

        if (bfs(beginWord, endWord)) {
            dfs(endWord, beginWord);
        }
        return ans;
    }


    // begin -> end ，一层层bfs去，建图
    // 返回值：真的能找到end，返回true；false
    public boolean bfs(String begin, String end) {

        boolean find = false;
        curLevel.add(begin);

        while (!curLevel.isEmpty()) {

            // 从码表中删除当前行的所有元素，防止重复走
            dict.removeAll(curLevel);

            for (String word : curLevel) {
                // word : 去扩
                // 每个位置，字符a~z，换一遍！检查在词表中是否存在
                // 避免，加工出自己
                char[] w = word.toCharArray();

                for (int i = 0; i < w.length; i++) {

                    char old = w[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // a-z 依次替换
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
                    // 还原
                    w[i] = old;
                }
            }

            if (find) {
                return true;
            } else {
                // 继续寻找从下一行寻找
                Set<String> tmp = curLevel;
                curLevel = nextLevel;
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
