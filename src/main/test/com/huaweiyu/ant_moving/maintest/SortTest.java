package com.huaweiyu.ant_moving.maintest;

import java.util.Arrays;

/**
 * @ClassName SortTest
 * @Description
 * @Author Zaizai
 * @Date 2021/4/25 2:16 下午
 **/
public class SortTest {

    public static void main(String[] args) {
        Integer[] sourceSort = new Integer[]{3,2,1,6,7,4,5};
        System.out.println("冒泡排序：" + Arrays.toString(bubbleSort(sourceSort)));
        int[] sourceSort1 = new int[]{3,2,1,6,7,4,5};
        System.out.println("快速排序：" + Arrays.toString(quickSort(sourceSort1, 0, 6)));
        int[] sourceSort2 = new int[]{3,2,1,6,7,4,5};
        System.out.println("归并排序：" + Arrays.toString(mergeSort(sourceSort2)));
        int[] sourceSort3 = new int[]{3,2,1,6,7,4,5};

    }

    /**
     * 冒泡排序
     * [321456]
     * [213456]
     * [123456]
     */
    private static Integer[] bubbleSort(Integer[] sourceSort) {
        for (int i = 1; i < sourceSort.length; i++) {
            for (int j = 0; j < sourceSort.length - i; j++) {
                if (sourceSort[j] > sourceSort[j + 1]) {
                    int temp = sourceSort[j];
                    sourceSort[j] = sourceSort[j + 1];
                    sourceSort[j + 1] = temp;
                }
            }
        }
        return sourceSort;
    }

    /**
     * 快速排序
     * [436215]
     * [1362 5]
     * [13 265]
     * [132465]
     * [132]4[65]
     */
    private static int[] quickSort(int[] arr, int low, int high) { // 分片递归
        if (low >= high) return arr; // 终止条件
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
        return arr;
    }

    //精髓在这里？！ 找到 分隔下标
    private static int partition(int[] arr, int low, int high) {
        int pivot = (low + high) / 2;
        swap(arr, high, pivot);  // 将 基准值放在最后
        int index = low;
        for (int i = low; i < high ; i++) {
            if (arr[i] < arr[high]) {
                swap(arr, i, index);  // 将比基准值小的数放在左侧
                index++; // 比基准值小的个数 对应+1
            }
        }
        swap(arr, index, high);  // 将 基准值 放在对应的下标位
        return index; //返回 下标位
    }

    private static void swap(int[] arr, int high, int pivot) {
        int temp = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = temp;
    }

    private static int[] mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        return arr;
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 分组
            int middle = (left + right) / 2;
            System.out.println("left " + left + " middle " + middle + " right " + right);
            sort(arr, left, middle, temp);
            sort(arr, middle + 1, right, temp);
            // 合并
            merge(arr, left, middle, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right, int[] temp) {
        int baseIndex = left;
        int i = left, j = middle + 1;
        for (; i <= middle && j <= right ; ) {
            if (arr[i] <=  arr[j]) {
                temp[baseIndex++] = arr[i++];
            } else {
                temp[baseIndex++] = arr[j++];
            }
        }

        if (i <= middle) {
            for (; i <= middle; i++, baseIndex++) {
                temp[baseIndex] = arr[i];
            }
        }

        if (j <= right) {
            for (; j <= right; j++, baseIndex++) {
                temp[baseIndex] = arr[j];
            }
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }



    private static void merge1(int[] a, int lo, int mid, int hi, int[] helper) {
        System.arraycopy(a, lo, helper, lo, hi + 1 - lo);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = helper[j++];
            else if (j > hi)
                a[k] = helper[i++];
            else if (helper[i] <= helper[j])
                a[k] = helper[i++];
            else
                a[k] = helper[j++];
        }
    }
}
