package com.at.经典排序算法;

public class 堆排序 {

    //堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
    //大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
    //小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
    //堆排序的平均时间复杂度为 Ο(nlogn)

    //创建一个堆 H[0……n-1]；
    //把堆首（最大值）和堆尾互换；
    //把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
    //重复步骤 2，直到堆的尺寸为 1

    // 数组与堆父子节点关系
    // 下标为 idx
    // 父节点 (idx - 1) / 2
    // 左孩子 idx * 2 + 1
    // 右孩子 idx * 2 + 2
    //      0
    //   1     2


    public static void main(String[] args) {

        System.out.println("堆排序");

        int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};

        int len = arr.length;

//        for (int i = 0; i < arr.length; i++) {
//            insertHeap(arr,i); // nlog2N
//        }
        for (int i = len - 1; i >= 0; i--) {
            insertHeap(arr,i); // log2N
        }
        int size = len;
        while (size > 1) {
            Utils.swap(arr, 0, --size);
            heapify(arr, 0, size); // log2N
        }


        Utils.print(arr);

    }

    public static void insertHeap(int[] arr, int idx) {
        // 与父节点比较，如果比父节点大，则调整
        while (arr[idx] > arr[(idx - 1) / 2]) {
            Utils.swap(arr, idx, (idx - 1) / 2);
            // 再往上找父节点
            idx = (idx - 1) / 2;
        }
    }

    public static void heapify(int arr[], int idx, int size) {

        // 左孩子索引
        int leftIdx = idx * 2 + 1;

        while (leftIdx < size) {

            // 左孩子与右孩子比较大小，获取最大的孩子的索引
            int largestIdx = leftIdx + 1 < size && arr[leftIdx + 1] > arr[leftIdx] ? leftIdx + 1 : leftIdx;

            // 左右孩子中最大的数与父节点比较
            largestIdx = arr[largestIdx] > arr[idx] ? largestIdx : idx;

            // 如果孩子节点中最大的数不大于父节点的数则退出，此时该子树已经大根堆
            if (largestIdx == idx) break;

            // 如果左右孩子的数比父节点的数大，则让最大的与父节点交换
            Utils.swap(arr, idx, largestIdx);

            // 将索引向下移，继续调整
            idx = largestIdx;
            leftIdx = idx * 2 + 1;

        }

    }


}
