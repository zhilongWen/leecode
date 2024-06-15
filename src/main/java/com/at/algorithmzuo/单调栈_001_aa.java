package com.at.algorithmzuo;

// 单调栈求每个位置左右两侧，离当前位置最近、且值严格小于的位置
// 给定一个可能含有重复值的数组 arr
// 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置
// 返回所有位置相应的信息。
// 输入描述：
// 第一行输入一个数字 n，表示数组 arr 的长度。
// 以下一行输入 n 个数字，表示数组的值
// 输出描述：
// 输出n行，每行两个数字 L 和 R，如果不存在，则值为 -1，下标从 0 开始。
// 测试链接 : https://www.nowcoder.com/practice/2a2c00e7a88a498693568cef63a4b7bb

import java.io.*;

public class 单调栈_001_aa {

    static int MAXN = 1000001;

    static int[] arr = new int[MAXN];

    static int[] stack = new int[MAXN];

    static int[][] ans = new int[MAXN][2];

    static int n, r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            compute();
            for (int i = 0; i < n; i++) {
                out.println(ans[i][0] + " " + ans[i][1]);
            }
        }
        out.flush();
        out.close();
        br.close();
    }

    /**
     * arr[0...n-1]
     */
    private static void compute() {

        r = 0;
        int curr;

        // 遍历
        for (int i = 0; i < n; i++) {

            // 将要入栈的比栈顶的要小
            while (r > 0 && arr[i] <= arr[stack[r - 1]]) {
                curr = stack[--r];
                ans[curr][0] = r > 0 ? stack[r - 1] : -1;
                ans[curr][1] = i;
            }

            stack[r++] = i;
        }

        // 清算
        while (r > 0) {

            curr = stack[--r];
            ans[curr][0] = r > 0 ? stack[r - 1] : -1;
            ans[curr][1] = -1;
        }

        // 修正
        for (int i = n - 2; i >= 0; i--) {
            if (ans[i][1] != -1 && arr[i] == arr[ans[i][1]]) {
                ans[i][1] = ans[ans[i][1]][1];
            }
        }
    }
}
