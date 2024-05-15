package com.at.algorithmzuo;

public class 蓄水池算法_001_aa {


    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());


        int test = 1000000;

        // 统计 17 个球进入桶的概率
        int[] count = new int[18];

        for (int i = 0; i < test; i++) {

            // 桶的大小
            int[] bag = new int[10];
            // 待淘汰的数据索引
            int bagi = 0;

            // 1 - 17 号球进入桶
            for (int num = 1; num <= 17; num++) {
                if (num <= 10) {
                    bag[bagi++] = num;
                } else {
                    // 大于 10 时进入桶
                    if (random(num) <= 10) {
                        bagi = (int) (Math.random() * 10);
                        bag[bagi] = num;
                    }
                }
            }

            for (int num : bag) {
                count[num]++;
            }
        }

        for (int i = 0; i <= 17; i++) {
            System.out.println(i  + " -> " + count[i]);
        }


    }


    // 等概率返回 1 ～ i 中的一个数字
    public static int random(int i) {
        return (int) (Math.random() * i) + 1;
    }

}
