package com.at.top100;

// https://leetcode.cn/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

public class _054_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int row = matrix.length, col = matrix[0].length;
        int l = 0, r = col - 1, top = 0, bot = row - 1;
        while (l <= r && top <= bot) {

            for (int i = l; i <= r; i++) {
                ans.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bot; i++) {
                ans.add(matrix[i][r]);
            }
            if (l < r && top < bot) {
                for (int i = r - 1; i > l; i--) {
                    ans.add(matrix[bot][i]);
                }
                for (int i = bot; i > top; i--) {
                    ans.add(matrix[i][l]);
                }
            }

            l++;
            r--;
            top++;
            bot--;
        }

        return ans;
    }
}
