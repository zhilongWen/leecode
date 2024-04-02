package com.at.algorithmzuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 广度优先_691_贴纸拼词 {

    public static void main(String[] args) {
        System.out.println(new 广度优先_691_贴纸拼词().minStickers(
                new String[]{"with", "example", "science"},
                "thehat"
        ));
    }


    private static int MAXN = 401;

    private static String[] queue = new String[MAXN];

    private static int l, r;

    // 下标0 -> a
    // 下标1 -> b
    // 下标2 -> c
    // ...
    // 下标25 -> z
    public static ArrayList<ArrayList<String>> graph = new ArrayList<>();

    static {
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // target 剩余的字符串
    public static HashSet<String> visited = new HashSet<>();


    public int minStickers(String[] stickers, String target) {

        // 初始化
        for (int i = 0; i < 26; i++) {
            graph.get(i).clear();
        }

        visited.clear();

        // 将贴纸排好序放入 graph 中
        for (String str : stickers) {
            str = sort(str);
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
                    graph.get(str.charAt(i) - 'a').add(str);
                }
            }
        }

        // 将 target 放入第一层,并标记为已经被访问
        target = sort(target);
        visited.add(target);
        l = r = 0;
        queue[r++] = target;

        int level = 0;
        // 按层遍历
        while (l < r) {
            int size = r - l;

            for (int i = 0; i < size; i++) {
                // 获取该层的一个元素
                String curr = queue[l++];

                // 将贴与该元素一一比较，现处理第一个位置的字符
                for (String s : graph.get(curr.charAt(0) - 'a')) {
                    String next = next(curr, s);
                    if (next.equals("")) {
                        return level + 1;
                    } else if (!visited.contains(next)) {
                        visited.add(next);
                        queue[r++] = next;
                    }
                }

            }
            level++;

        }

        return -1;

    }

    public static String next(String t, String s) {

        // t: aabccff 待匹配的目标字符串
        //    i
        // s: abde    贴纸
        //    j

        StringBuffer buffer = new StringBuffer();

        for (int i = 0, j = 0; i < t.length(); ) {

            if (j == s.length()) {
                // 贴纸全部用完，将待匹配的字符放回字符串中
                buffer.append(t.charAt(i++));
            } else {

                if (t.charAt(i) < s.charAt(j)) {
                    // t: aabccff 待匹配的目标字符串
                    //     i
                    // s: abde    贴纸
                    //     j
                    buffer.append(t.charAt(i));
                    i++;
                } else if (t.charAt(i) > s.charAt(j)) {
                    // t: aabccff 待匹配的目标字符串
                    //         i
                    // s: abde    贴纸
                    //      j
                    j++;
                } else {
                    // t: aabccff 待匹配的目标字符串
                    //    i
                    // s: abde    贴纸
                    //    j
                    i++;
                    j++;
                }
            }

        }

        return buffer.toString();
    }

    public static String sort(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return String.valueOf(s);
    }


}
