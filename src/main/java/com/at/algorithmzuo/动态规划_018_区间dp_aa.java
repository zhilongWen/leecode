package com.at.algorithmzuo;


// 完成配对需要的最少字符数量
// 给定一个由'['、']'、'('，')'组成的字符串
// 请问最少插入多少个括号就能使这个字符串的所有括号正确配对
// 例如当前串是 "([[])"，那么插入一个']'即可满足
// 输出最少需要插入多少个字符
// 测试链接 : https://www.nowcoder.com/practice/e391767d80d942d29e6095a935a5b96b
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过


import java.io.*;


public class 动态规划_018_区间dp_aa {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        out.println(compute(str));
        out.flush();
        out.close();
        br.close();
    }

    // 时间复杂度O(n^3)
    public static int compute(String str) {

        int n = str.length();
        char[] arr = str.toCharArray();

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return f(arr, 0, n - 1, dp);

    }


    public static int f(char[] arr, int l, int r, int[][] dp) {

        //  只有一个字符，则至少插入 1 个
        if (l == r) return 1;

        // 有两个字符
        // ()
        // []
        // )]
        // )[
        // ...
        if (l + 1 == r) {
            if ((arr[l] == '(' && arr[r] == ')') || (arr[l] == '[' && arr[r] == ']')) return 0;
            return 2;
        }

        // >= 3
        if (dp[l][r] != -1) return dp[l][r];

        // 可能性1 : [l]、[r]本来就是配对的
        int p1 = Integer.MAX_VALUE;
        if ((arr[l] == '(' && arr[r] == ')') || (arr[l] == '[' && arr[r] == ']')) {
            p1 = f(arr, l + 1, r - 1, dp);
        }

        // 可能性2 : 基于每个可能的划分点，做左右划分
        int p2 = Integer.MAX_VALUE;
        for (int m = l; m < r; m++) {
            // l ....... r
            // l   m     r
            p2 = Math.min(p2, f(arr, l, m, dp) + f(arr, m + 1, r, dp));
        }

        int ans = Math.min(p1, p2);

        dp[l][r] = ans;

        return ans;

    }


}
