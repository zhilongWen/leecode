package com.at.algorithmzuo;

import java.io.*;
import java.util.Arrays;

// 分组背包(模版)
// 自01背包问世之后，小 A 对此深感兴趣
// 一天，小 A 去远游，却发现他的背包不同于 01 背包，他的物品大致可分为 k 组
// 每组中的物品只能选择1件，现在他想知道最大的利用价值是多少
// 测试链接 : https://www.luogu.com.cn/problem/P1757
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的所有代码，并把主类名改成"Main"，可以直接通过

public class 动态规划_006_分组背包_aa {

    public static int MAXN = 1001;

    public static int MAXM = 1001;

    // arr[i][0] 重量
    // arr[i][1] 价值
    // arr[i][2] 组号
    public static int[][] arr = new int[MAXN][3];

    public static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // 背包容量
            m = (int) in.nval;
            in.nextToken();
            // 物品数
            n = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                // 重量
                arr[i][0] = (int) in.nval;
                in.nextToken();
                // 价值
                arr[i][1] = (int) in.nval;
                in.nextToken();
                // 组号
                arr[i][2] = (int) in.nval;
            }
            // 按组号排序
            Arrays.sort(arr, 1, n + 1, (a, b) -> a[2] - b[2]);
            out.println(compute2());
        }
        out.flush();
        out.close();
        br.close();
    }

    // 严格位置依赖的动态规划
    public static int compute1() {

        // 分组
        int team = 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i - 1][2] != arr[i][2]) {
                team++;
            }
        }

        // dp[i][m] i 组中容量小于等于 m 价值最大
        int[][] dp = new int[team + 1][m + 1];

        for (int start = 1, end = 2, k = 1; start <= n; k++) {
            //找到该组所有的商品
            while (end <= n && arr[start][2] == arr[end][2]) {
                end++;
            }

            // start .... start-1 为当前组的所有数据

            // j 是容量
            for (int j = 0; j <= m; j++) {

                // 不要当前组
                dp[k][j] = dp[k - 1][j];
                // 当前组任选一个
                for (int i = start; i < end; i++) {

                    if (j >= arr[i][0]) {
                        dp[k][j] = Math.max(dp[k][j], dp[k - 1][j - arr[i][0]] + arr[i][1]);
                    }
                }
            }

            start = end++;
        }

        return dp[team][m];
    }

    // 空间压缩
    public static int compute2() {

        int[] dp = new int[m + 1];
        // dp[0][..]  没有物品 价值全为 0
        for (int start = 1, end = 2; start <= n; ) {

            while (end <= n && arr[end][2] == arr[start][2]) {
                end++;
            }

            for (int j = m; j >= 0; j--) {
                for (int i = start; i < end; i++) {
                    if (j >= arr[i][0]) {
                        dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
                    }
                }
            }

            start = end++;
        }

        return dp[m];
    }


}
