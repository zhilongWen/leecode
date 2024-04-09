package com.at.algorithmzuo;

import java.io.*;
import java.util.Arrays;

public class 动态规划_01背包_aa {

    public static int MAXM = 101;

    public static int MAXT = 1001;

    public static int[] cost = new int[MAXM];

    public static int[] val = new int[MAXM];

    public static int[] dp = new int[MAXT];

    public static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            t = (int) in.nval;
            in.nextToken();
            n = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                cost[i] = (int) in.nval;
                in.nextToken();
                val[i] = (int) in.nval;
            }
            out.println(compute2());
        }
        out.flush();
        out.close();
        br.close();
    }

    // 严格位置依赖的动态规划
    // n个物品编号1~n，第i号物品的花费cost[i]、价值val[i]
    // cost、val数组是全局变量，已经把数据读入了
    public static int compute1() {

        // dp[i][j] 表示选前 i 个物体花费不超过 j 情况下的最大值
        int[][] dp = new int[n + 1][t + 1];

        // dp[0][0...t] 表示什么都不选

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                // 不要 i 号物品，那么其就是 i-1号物品的最大值
                dp[i][j] = dp[i - 1][j];

                // 要 i 号物品，但是选取后价值不能超 j - cost[i]
                if (j - cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + val[i]);
                }
            }
        }

        return dp[n][t];

    }


    // 空间压缩
    public static int compute2() {

        Arrays.fill(dp, 0, t + 1, 0);

        for (int i = 1; i <= n; i++) {
            for (int j = t; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + val[i]);
            }
        }


        return dp[t];
    }
}
