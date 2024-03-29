package com.at.algorithmzuo;

public class 广度优先_1162_地图分析 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0},
                {1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1},
                {0,0,1,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0},
                {0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,0,1},
                {1,0,1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0},
                {0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1},
                {0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,0},
                {1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,0,0,1},
                {0,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,1,0,0,0},
                {1,0,1,0,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,0},
                {0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},
                {0,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0},
                {0,0,1,1,0,0,1,1,1,1,1,1,1,0,1,0,1,0,0,0},
                {0,1,0,1,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,1},
                {1,0,0,0,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
                {0,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1},
                {1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,0},
                {1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1},
                {0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0}};

        System.out.println(maxDistance(grid));


    }

    private static int MAXN = 101;
    private static int MAXM = 101;

    private static int[][] queue = new int[MAXN * MAXM][2];

    private static int l, r; // r 表示该层有多少个元素 m 表示该层遍历到了第几个

    private static boolean[][] visited = new boolean[MAXN][MAXM];

    // 上/右/下/左
    // (x,y)
    // 上：(x-1,y)
    // 右：(x,y+1)
    // 下：(x+1,y)
    // 左：(x,y-1)
    private static int[] move = new int[]{-1, 0, 1, 0, -1};


    public static int maxDistance(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        l = r = 0;

        int seas = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    visited[i][j] = false;
                    seas++;
                }
            }
        }

        if (seas == 0 || seas == n * m) return -1;

        int level = 0;

        while (l < r) {

            level++;
            int size = r - l;

            for (int k = 0, x, y, nx, ny; k < size; k++) {

                x = queue[l][0];
                y = queue[l++][1];

                for (int i = 0; i < 4; i++) {

                    nx = x + move[i];
                    ny = y + move[i + 1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0 && !visited[nx][ny]) {

                        visited[nx][ny] = true;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;

                    }
                }
            }
        }

        return level - 1;

    }


}
