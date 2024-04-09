package com.at.algorithmzuo;

import java.util.ArrayDeque;

public class 广度优先_003_01_2290_到达角落需要移除障碍物的最小数目 {

    public int minimumObstacles(int[][] grid) {

        // 上右下左
        int[] move = new int[]{-1, 0, 1, 0, -1};

        int m = grid.length;
        int n = grid[0].length;

        int[][] distinct = new int[m][n];

        // 假设出发点到所有点的距离都是无穷大
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distinct[i][j] = Integer.MAX_VALUE;
            }
        }

        // 创建一个双端队列
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        // 起点到自己的距离为 0，将其往队列头部加入
        deque.addFirst(new int[]{0, 0});
        distinct[0][0] = 0;

        // 遍历队列
        while (!deque.isEmpty()) {

            // 每次从队列头部取出一个
            int[] record = deque.pollFirst();

            int x = record[0];
            int y = record[1];

            if (x == m - 1 && y == n - 1) {
                // 到达终点
                return distinct[x][y];
            }

            // 依次查看该位置 上右下左 的元素
            for (int i = 0; i < 4; i++) {

                int nx = x + move[i];
                int ny = y + move[i + 1];

                if (
                    // 不越界
                        nx >= 0 && nx < m && ny >= 0 && ny < n
                                // 现在到该点的距离大于将要从上一个点到该点的距离
                                && distinct[nx][ny] > distinct[x][y] + grid[nx][ny]
                ) {

                    distinct[nx][ny] = distinct[x][y] + grid[nx][ny];

                    if (grid[nx][ny] == 0) {
                        deque.addFirst(new int[]{nx, ny});
                    } else {
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;

    }

}
