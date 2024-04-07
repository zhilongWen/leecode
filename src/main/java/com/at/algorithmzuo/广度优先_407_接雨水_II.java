package com.at.algorithmzuo;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class 广度优先_407_接雨水_II {

    public int trapRainWater(int[][] heightMap) {

        int n = heightMap.length;
        int m = heightMap[0].length;

        // 上右下左
        int move[] = new int[]{-1, 0, 1, 0, -1};

        boolean[][] visit = new boolean[n][m];

        // 行 列 高
        PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[2] - r[2]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    // 边界
                    queue.add(new int[]{i, j, heightMap[i][j]});
                    visit[i][j] = true;
                } else {
                    // 中间
                    visit[i][j] = false;
                }
            }
        }


        int ans = 0;

        while (!queue.isEmpty()) {
            int[] record = queue.poll();
            int r = record[0];
            int c = record[1];
            int w = record[2];

            ans += w - heightMap[r][c];

            for (int i = 0; i < 4; i++) {

                int nr = r + move[i];
                int nc = c + move[i + 1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new int[]{nr, nc, Math.max(w, heightMap[nr][nc])});
                }

            }


        }

        return ans;
    }
}
