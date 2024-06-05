package com.at.top100;

// https://leetcode.cn/problems/set-matrix-zeroes/description/

public class _073_矩阵置零 {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m], col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        boolean row = false, col = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        col = true;
                    }
                    if (i == 0) {
                        row = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n && row; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < m && col; i++) {
            matrix[i][0] = 0;
        }
    }
}
