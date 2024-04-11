package com.at.algorithmzuo;

// 依赖背包(模版)
// 物品分为两大类：主件和附件
// 主件的购买没有限制，钱够就可以
// 附件的购买有限制，该附件所归属的主件先购买，才能购买这个附件
// 例如若想买打印机或扫描仪这样的附件，必须先购买电脑这个主件
// 以下是一些主件及其附件的展示：
// 电脑：打印机，扫描仪
// 书柜：图书
// 书桌：台灯，文具
// 工作椅：无附件
// 每个主件最多有2个附件，并且附件不会再有附件
// 主件购买后，去选择归属附件完全随意，钱够就可以
// 所有的物品编号都在1~m之间，每个物品有三个信息：价格v、重要度p、归属q
// 价格就是花费，价格 * 重要度 就是收益，归属就是该商品是依附于哪个编号的主件
// 比如一件商品信息为[300,2,6]，花费300，收益600，该商品是6号主件商品的附件
// 再比如一件商品信息[100,4,0]，花费100，收益400，该商品自身是主件(q==0)
// 给定m件商品的信息，给定总钱数n，返回再不违反购买规则的情况下最大的收益
// 测试链接 : https://www.luogu.com.cn/problem/P1064
// 测试链接 : https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的所有代码，并把主类名改成"Main"，可以直接通过


import java.io.*;

public class 动态规划_004_有依赖背包_aa {

    public static int MAXN = 33001;

    //
    public static int MAXM = 61;

    // 花费
    public static int[] cost = new int[MAXM];

    // 价值
    public static int[] val = new int[MAXM];

    // 是否是主商品
    public static boolean[] king = new boolean[MAXM];

    // 有几个附件
    public static int[] fans = new int[MAXM];

    // 附件的下标
    // follows[4][0] = 1 第 4 个位置的商品的第一个附件是第 1 个商品
    public static int[][] follows = new int[MAXM][2];

//    public static int[] dp = new int[MAXN];

    // n 总金额，m 物品数
    public static int n, m;

    public static void clean() {
        for (int i = 1; i <= m; i++) {
            fans[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            clean();
            for (int i = 1, v, p, q; i <= m; i++) {
                in.nextToken();
                v = (int) in.nval;
                in.nextToken();
                p = (int) in.nval;
                in.nextToken();
                q = (int) in.nval;
                cost[i] = v;
                val[i] = v * p;
                king[i] = q == 0;
                if (q != 0) {
                    follows[q][fans[q]++] = i;
                }
            }
            out.println(compute1());
        }
        out.flush();
        out.close();
        br.close();
    }

    // 严格位置依赖的动态规划
    public static int compute1() {

        int[][] dp = new int[m + 1][n + 1];

        // 上一个主商品
        int p = 0;

        for (int i = 1; i <= m; i++) {

            // 判断是否为主商品
            if (!king[i]) continue;

            for (int j = 0; j <= n; j++) {

                // 不要当前的主商品
                dp[i][j] = dp[p][j];

                // 要当前的主商品，并且花费不能超
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - cost[i]] + val[i]);
                }

                //  判断是否有附件 1
                int f1 = fans[i] >= 1 ? follows[i][0] : -1;
                if (f1 != -1 && j >= cost[i] + cost[f1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - cost[i] - cost[f1]] + val[i] + val[f1]);
                }

                //  判断是否有附件 2
                int f2 = fans[i] >= 2 ? follows[i][1] : -1;
                if (f2 != -1 && j >= cost[i] + cost[f2]) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - cost[i] - cost[f2]] + val[i] + val[f2]);
                }

                // 两个附件都选
                if (f1 != -1 && f2 != -1 && j >= cost[i] + cost[f1] + cost[f2]) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - cost[i] - cost[f1] - cost[f2]] + val[i] + val[f1] + val[f2]);
                }

            }

            p = i;
        }

        return dp[p][n];

    }

}
