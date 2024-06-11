package com.at.top100;

// https://leetcode.cn/problems/search-a-2d-matrix/description/

public class _074_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0, r = m * n - 1;
        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                l = mid + 1;
            } else if (x > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
