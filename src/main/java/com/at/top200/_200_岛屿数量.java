package com.at.top200;

public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {

        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, m, n);
                }
            }
        }


        return ans;
    }

    public void dfs(char[][] grid, int x, int y, int m, int n) {

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(grid, x + 1, y, m, n);
        dfs(grid, x - 1, y, m, n);
        dfs(grid, x, y + 1, m, n);
        dfs(grid, x, y - 1, m, n);

    }
}
