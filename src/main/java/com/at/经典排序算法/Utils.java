package com.at.经典排序算法;

import java.util.Arrays;

public class Utils {

    public static void swap(int[] arr,int left,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }


}

