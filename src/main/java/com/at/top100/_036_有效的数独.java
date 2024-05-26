package com.at.top100;


// https://leetcode.cn/problems/valid-sudoku/

public class _036_有效的数独 {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int buk = 3 * (i / 3) + j / 3;

                    if (row[i][num] || col[j][num] || bucket[buk][num]) return false;

                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[buk][num] = true;
                }
            }
        }

        return true;
    }
}
