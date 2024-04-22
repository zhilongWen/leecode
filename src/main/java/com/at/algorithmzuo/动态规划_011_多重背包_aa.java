package com.at.algorithmzuo;

// 多重背包不进行枚举优化
// 宝物筛选
// 一共有n种货物, 背包容量为t
// 每种货物的价值(v[i])、重量(w[i])、数量(c[i])都给出
// 请返回选择货物不超过背包容量的情况下，能得到的最大的价值
// 测试链接 : https://www.luogu.com.cn/problem/P1776
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

public class 动态规划_011_多重背包_aa {

    public static int MAXN = 101;

    public static int MAXW = 40001;

    public static int[] v = new int[MAXN];

    public static int[] w = new int[MAXN];

    public static int[] c = new int[MAXN];

    public static int[] dp = new int[MAXW];

    public static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // 数量
            n = (int) in.nval;
            in.nextToken();
            // 背包大小
            t = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                // 物品价值
                v[i] = (int) in.nval;
                in.nextToken();
                // 物品体积
                w[i] = (int) in.nval;
                in.nextToken();
                // 物品数量
                c[i] = (int) in.nval;
            }
            out.println(compute2());
        }
        out.flush();
        out.close();
        br.close();
    }

    // 严格位置依赖的动态规划
    // 时间复杂度O(n * t * 每种商品的平均个数)
    public static int compute1() {

        // dp[0][....] = 0，表示没有货物的情况下，背包容量不管是多少，最大价值都是0
        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {

                // 不要
                dp[i][j] = dp[i - 1][j];

                //要 n 个
                for (int k = 1; k <= c[i] && k * w[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i]] + k * v[i]);
                }
            }
        }

        return dp[n][t];

    }

    // 空间压缩
    // 部分测试用例超时
    // 因为没有优化枚举
    // 时间复杂度O(n * t * 每种商品的平均个数)
    public static int compute2() {
        for (int i = 1; i <= n; i++) {
            for (int j = t; j >= 0; j--) {
                for (int k = 1; k <= c[i] && k * w[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * w[i]] + k * v[i]);
                }

            }
        }

        return dp[t];
    }

}
