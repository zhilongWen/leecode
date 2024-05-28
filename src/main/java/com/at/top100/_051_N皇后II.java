package com.at.top100;

// https://leetcode.cn/problems/n-queens-ii/

import java.util.HashSet;
import java.util.Set;

public class _051_N皇后II {

    Set<Integer> col = new HashSet<>();
    Set<Integer> dig1 = new HashSet<>();
    Set<Integer> dig2 = new HashSet<>();

    public int totalNQueens(int n) {
        return dfs(n, 0);
    }

    public int dfs(int n, int row) {

        if (row == n) {
            return 1;
        }

        int cnt = 0;
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

            col.add(i);
            dig1.add(d1);
            dig2.add(d2);
            cnt += dfs(n, row + 1);
            col.remove(i);
            dig1.remove(d1);
            dig2.remove(d2);
        }

        return cnt;
    }
}
