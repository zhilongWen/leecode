package com.at.经典排序算法;

public class 希尔排序 {

    // 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法
    //希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序
    //选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
    //按增量序列个数 k，对序列进行 k 趟排序；
    //每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
    public static void main(String[] args) {

        System.out.println("希尔排序");

        int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70}; // {100, 3, 1, 5, 39, 60, 71, 6, 10, -1, 9, 8};

        int len = arr.length;
        int tmp;

        for (int step = len / 2; step >= 1; step /= 2) {

            for (int i = step; i < len; i++) {
                tmp = arr[i];
                int idx = i - step;

                while (idx >= 0 && arr[idx] > tmp) {
                    arr[idx + step] = arr[idx];
                    idx -= step;
                }

                arr[idx + step] = tmp;
            }

        }


        Utils.print(arr);


    }

}
