package com.at.top100;


// https://leetcode.cn/problems/sudoku-solver/

public class _037_解数独 {

    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] bucket = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int buk = 3 * (i / 3) + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[buk][num] = true;
                }
            }
        }

        dfs(board, 0, 0);

    }

    public boolean dfs(char[][] board, int x, int y) {

        if (x == 9) {
            return true;
        }

        int nextX = y != 8 ? x : x + 1;
        int nextY = y != 8 ? y + 1 : 0;
        int buk = 3 * (x / 3) + y / 3;

        if (board[x][y] != '.') {
            return dfs(board, nextX, nextY);
        }

        for (int i = 1; i <= 9; i++) {

            if (row[x][i] || col[y][i] || bucket[buk][i]) {
                continue;
            }

            row[x][i] = true;
            col[y][i] = true;
            bucket[buk][i] = true;
            board[x][y] = (char) (i + '0');

            if (dfs(board, nextX, nextY)) {
                return true;
            }

            row[x][i] = false;
            col[y][i] = false;
            bucket[buk][i] = false;
            board[x][y] = '.';

        }

        return false;
    }
}
