package com.at.经典排序算法;

public class 归并排序 {

    //归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
    //作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
    //自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
    //自下而上的迭代；

    //申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
    //设定两个指针，最初位置分别为两个已经排序序列的起始位置；
    //比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
    //重复步骤 3 直到某一指针达到序列尾；
    //将另一序列剩下的所有元素直接复制到合并序列尾


    private static int arr[] = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};

    private static int len = arr.length;

    private static int help[] = new int[arr.length];

    public static void main(String[] args) {

        System.out.println("归并排序");

//        sort(0, len - 1);
        sort1();

        Utils.print(arr);

    }


    public static void sort(int l, int r) {

        if (l == r) return;

        // 中点
        int m = (l + r) / 2;

        sort(l, m);
        sort(m + 1, r);

        merge(l, m, r);

    }

    public static void sort1() {

        for (int l, m, r, step = 1; step < len; step <<= 1) {

            l = 0;

            while (l < len) {
                // 左侧最后一个位置
                m = l + step - 1;

                if (m + 1 >= len) break;

                r = Math.min(l + (step << 1) - 1, len - 1);

                merge(l, m, r);

                l = r + 1;

            }

        }


    }


    public static void merge(int l, int m, int r) {

        // 填充位置的索引
        int i = l;

        int a = l;
        int b = m + 1;

        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        // 上面的结束后必然有一边为空
        while (a <= m) {
            help[i++] = arr[a++];
        }

        while (b <= r) {
            help[i++] = arr[b++];
        }

        // 将数据拷贝到原数组
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }

    }

}
