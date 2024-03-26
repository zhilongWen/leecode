package com.at.经典排序算法;

import java.util.Random;

public class 快速排序 {


    //从数列中挑出一个元素，称为 "基准"（pivot）;
    //重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    //递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；

    private static int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};

    public static void main(String[] args) {

        System.out.println("快速排序");

//        sort(0, arr.length - 1);
        sort1(0, arr.length - 1);

        Utils.print(arr);


    }


    public static void sort1(int l, int r) {

        if (l >= r) return;

        int randomIdx = (int) Math.random() * (r - l + 1);

        int[] p = partition1(l, r, arr[randomIdx]);

        sort(l, p[0] - 1);
        sort(p[0] + 1, r);

    }


    public static int[] partition1(int l, int r, int x) {

        int a = l;
        int i = l;
        int b = r;

        while (i <= b) {

            //  > x     i,b 交换，b--
            //  = x     i++
            //  < x     a,i 交换 a++，i++

            if (arr[i] > x) {
                Utils.swap(arr, i, b);
                b--;
            } else if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                Utils.swap(arr, a, i);
                a++;
                i++;
            }
        }

        return new int[]{a, i - 1};


    }

    // ================

    public static void sort(int l, int r) {

        if (l >= r) return;

        // l 到 r 位置随机选一个数
        int x = arr[l + (int) Math.random() * (r - l + 1)];

        int m = partition(l, r, x);

        sort(l, m - 1);
        sort(m + 1, r);


    }


    private static int partition(int l, int r, int x) {

        int a = l, i = l;
        int xIdx = 0;

        for (; i <= r; ) {

            if (arr[i] <= x) {
                Utils.swap(arr, a, i);

                // 找到 x 这个数的一个位置
                if (arr[a] == x) {
                    xIdx = a;
                }

                a++;
                i++;
            } else {
                i++;
            }

        }

        Utils.swap(arr, a - 1, xIdx);

        return a - 1;

    }

}
