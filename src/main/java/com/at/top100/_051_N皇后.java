package com.at.top100;

// https://leetcode.cn/problems/n-queens/description/

import java.util.*;

public class _051_N皇后 {

    List<List<String>> ans = new ArrayList<>();
    int[] queue;
    Set<Integer> col = new HashSet<>();
    Set<Integer> dig1 = new HashSet<>();
    Set<Integer> dig2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {

        queue = new int[n];
        Arrays.fill(queue, -1);
        dfs(n, 0);

        return ans;
    }

    public void dfs(int n, int row) {

        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[queue[i]] = 'Q';
                list.add(String.valueOf(arr));
            }
            ans.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (col.contains(i)) {
                continue;
            }
            int d1 = row - i;
            if (dig1.contains(d1)) {
                continue;
            }
            int d2 = row + i;
            if (dig2.contains(d2)) {
                continue;
            }

            queue[row] = i;
            col.add(i);
            dig1.add(d1);
            dig2.add(d2);
            dfs(n, row + 1);
            queue[row] = -1;
            col.remove(i);
            dig1.remove(d1);
            dig2.remove(d2);
        }
    }
}
