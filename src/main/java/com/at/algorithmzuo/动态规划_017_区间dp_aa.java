package com.at.algorithmzuo;


// 布尔运算
// 给定一个布尔表达式和一个期望的布尔结果 result
// 布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成
// 布尔表达式一定是正确的，不需要检查有效性
// 但是其中没有任何括号来表示优先级
// 你可以随意添加括号来改变逻辑优先级
// 目的是让表达式能够最终得出result的结果
// 返回最终得出result有多少种不同的逻辑计算顺序
// 测试链接 : https://leetcode.cn/problems/boolean-evaluation-lcci/


public class 动态规划_017_区间dp_aa {

    public int countEval(String s, int result) {

        char[] arr = s.toCharArray();
        int n = arr.length;

        int[][][] dp = new int[n][n][];
        int[] ft = f(arr, 0, n - 1, dp);
        return ft[result];

    }

    // s[l...r]是表达式的一部分，且一定符合范式
    // 0/1  逻  0/1   逻       0/1
    //  l  l+1  l+2  l+3........r
    // s[l...r]  0 : ?
    //           1 : ?
    // ans : int[2] ans[0] = false方法数 ans[0] = true方法数
    public int[] f(char[] arr, int l, int r, int dp[][][]) {

        if (dp[l][r] != null) {
            return dp[l][r];
        }

        int f = 0;
        int t = 0;

        if (l == r) {
            // 只剩一个字符，0/1
            f = arr[l] == '1' ? 0 : 1;
            t = arr[l] == '1' ? 1 : 0;
        } else {

            int[] tmp;
            for (int k = l + 1, a, b, c, d; k < r - 1; k += 2) {
                // l ... r
                // 枚举每一个逻辑符号最后执行 k = l+1 ... r-1  k+=2
                tmp = f(arr, l, k - 1, dp);
                a = tmp[0];
                b = tmp[1];

                tmp = f(arr, k + 1, r, dp);
                c = tmp[0];
                d = tmp[1];

                if (arr[k] == '&') {
                    f += a * c + a * d + b * c;
                    t += b * d;
                } else if (arr[k] == '|') {
                    f += a * c;
                    t += a * d + b * c + b * d;
                } else {
                    f += a * c + b * d;
                    t += a * d + b * c;
                }

            }

        }

        int[] ft = new int[]{f, t};
        dp[l][r] = ft;
        return ft;

    }

}
