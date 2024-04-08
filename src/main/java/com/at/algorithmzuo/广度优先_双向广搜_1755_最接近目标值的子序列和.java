package com.at.algorithmzuo;


import java.util.Arrays;

public class 广度优先_双向广搜_1755_最接近目标值的子序列和 {

    public static void main(String[] args) {

        int[] s = new int[]{5,-7,3,5};

        System.out.println(new 广度优先_双向广搜_1755_最接近目标值的子序列和().minAbsDifference(s, 6));

    }

    static int MAXN = 20;

    static int MAXM = 1 << 20;

    static int[] lsum = new int[MAXM];
    static int[] rsum = new int[MAXM];

    static int fill;

    public int minAbsDifference(int[] nums, int goal) {

        int n = nums.length;

        long min = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] >= 0) {
                max += nums[i];
            } else {
                min += nums[i];
            }
        }

        // 目标 120，最大值 100
        //     -120 最小值 -100
        if (goal >= max) {
            return (int) Math.abs(max - goal);
        }
        if (goal <= min) {
            return (int) Math.abs(min - goal);
        }

        fill = 0;

        // 左半部分展开
        collect(nums, 0, n >> 1, 0, lsum);
        int lsize = fill;
        fill = 0;

        // 右半部分展开
        collect(nums, n >> 1, n, 0, rsum);
        int rsize = fill;
        fill = 0;

        // 排序
        Arrays.sort(lsum,0,lsize);
        Arrays.sort(rsum,0,rsize);

        int ans = Math.abs(goal);
        // 双指针遍历
        for (int i = 0, j = rsize - 1; i < lsize; i++) {

            while (j > 0 &&
                    // 加上下一个值会比当前值小
                    Math.abs(goal - lsum[i] - rsum[j - 1]) <= Math.abs(goal - lsum[i] - rsum[j])) {
                // 找下一个
                j--;
            }




//            while (j > 0){
//                int i1 = lsum[i];
//                int j_0 = rsum[j];
//                int j_1 = rsum[j - 1];
//
//                int a = Math.abs(goal - i1 - j_1);
//                int b = Math.abs(goal - i1 - j_0);
//
//                if (a <= b){
//                    j--;
//                }else {
//                    break;
//                }
//
//
//            }

            ans = Math.min(ans, Math.abs(goal - lsum[i] - rsum[j]));

        }


        return ans;

    }

    // arr[i.....e] i-e 位置展开
    // i 起始位置
    // e 结束位置
    // s 累加和
    public static void collect(int[] nums, int i, int e, int s, int[] sum) {

        if (i == e) {
            sum[fill++] = s;
        } else {

            // 要 nums[i]
            collect(nums, i + 1, e, s + nums[i], sum);

            // 不要 nums[i]
            collect(nums, i + 1, e, s, sum);
        }


    }

}
