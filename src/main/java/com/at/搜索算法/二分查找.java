package com.at.搜索算法;

import com.at.经典排序算法.Utils;

import java.util.Arrays;

public class 二分查找 {

    public static final int arr[] = {3, 5, 9, 22, 32, 34, 35, 37, 50, 55, 64, 70, 82, 89};

    public static void main(String[] args) {


        System.out.println("二分查找");

        Utils.print(arr);

        int l = 0;
        int r = arr.length - 1;

        int idx = find(l, r, 20);

        System.out.println(idx);


    }

    public static int find(int l, int r, int x) {

        int idx = -1;

        while (l <= r) {

            int m = (l + r) / 2;

            if (arr[m] > x) {
                r = m - 1;
            } else if (arr[m] < x) {
                l = m + 1;
            } else {
                idx = m;
                break;
            }
        }


        return idx;

    }


}
