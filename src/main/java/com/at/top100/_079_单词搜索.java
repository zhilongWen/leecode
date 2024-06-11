package com.at.top100;

// hhttps://leetcode.cn/problems/word-search/description/

public class _079_单词搜索 {

    int[] move = new int[]{-1, 0, 1, 0, -1};

    char[][] board;
    char[] word;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int x, int y, int k) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word[k]) {
            return false;
        }

        if (k == word.length - 1) {
            return true;
        }

        board[x][y] = '\0';

        boolean ans = false;
        for (int a = 0; a < 4; a++) {
            ans = dfs(x + move[a], y + move[a + 1], k + 1);
            if (ans) {
                return true;
            }
        }

        board[x][y] = word[k];

        return ans;
    }
}
