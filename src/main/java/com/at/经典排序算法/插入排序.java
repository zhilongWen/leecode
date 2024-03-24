package com.at.经典排序算法;

public class 插入排序 {

    //将第一待排序序列第一个元素看做一个有序序列，
    //把第二个元素到最后一个元素当成是未排序序列。
    //从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
    public static void main(String[] args) {

        System.out.println("插入排序");

        int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};

        for (int i = 1; i < arr.length; i++) {
            //将前的 i 个元素看成是有序的 将后面的元素插入其中

//            int idx = i;
//            while (--idx >= 0 && arr[idx + 1] < arr[idx]){
//                Utils.swap(arr,idx,idx+1);
//            }

            int tmp = arr[i];
            int idx = i;

            while (idx > 0 && tmp < arr[idx - 1]) {
                arr[idx] = arr[idx - 1];
                idx--;
            }

            if (idx != i) {
                arr[idx] = tmp;
            }

        }

        Utils.print(arr);


    }
}
