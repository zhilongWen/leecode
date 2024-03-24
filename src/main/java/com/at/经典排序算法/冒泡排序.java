package com.at.经典排序算法;

import java.util.Arrays;

public class 冒泡排序 {

    //比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    //对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
    //针对所有的元素重复以上的步骤，除了最后一个。
    //持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

    public static void main(String[] args) {

        System.out.println("冒泡排序");

        int arr[] = { 22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70 };

        // 比较 length - 1 次，最后一个无需比较
        for (int i = 0; i < arr.length - 1; i++) {

            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            // 从第一个元素开始比较，最后几个元素已经是排好序的
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    Utils.swap(arr,j,j+1);
                    flag = false;
                }
            }

            // flag 为 true 表示所有数据已经有序
            if (flag) break;

        }

        Utils.print(arr);

    }




}
