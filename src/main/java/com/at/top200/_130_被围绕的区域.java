package com.at.top200;

// https://leetcode.cn/problems/surrounded-regions/

public class _130_被围绕的区域 {

    int[] move = new int[]{-1, 0, 1, 0, -1};

    char[][] board;
    int n, m;

    public void solve(char[][] board) {

        this.board = board;
        this.n = board.length;
        this.m = board[0].length;

        // 左右
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O') {
                dfs(i, 0);
            }

            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1);
            }
        }

        // 上下
        for (int i = 0; i < m; i++) {

            if (board[0][i] == 'O') {
                dfs(0, i);
            }

            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int x, int y) {

        board[x][y] = 'A';

        for (int i = 0; i < 4; i++) {

            int nx = x + move[i];
            int ny = y + move[i + 1];

            if (!(nx >= 0 && nx < n && ny >= 0 && ny < m)) {
                continue;
            }

            if (board[nx][ny] == 'X' || board[nx][ny] == 'A') {
                continue;
            }

            dfs(nx, ny);
        }
    }
}
