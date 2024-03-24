package com.at.经典排序算法;

public class 选择排序 {

    //首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
    //再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    //重复第二步，直到所有元素均排序完毕。

    public static void main(String[] args) {

        System.out.println("选择排序");

        int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};

        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }

            if(i != minIdx) Utils.swap(arr,i,minIdx);
        }

        Utils.print(arr);
    }

}
