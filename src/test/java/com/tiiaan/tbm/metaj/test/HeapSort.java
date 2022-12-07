package com.tiiaan.tbm.metaj.test;

import java.util.Arrays;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class HeapSort {

    public static void maxHeapSink(int[] arr, int curr, int tail) {
        int left = 2 * curr + 1;
        while (left <= tail) {
            if (left < tail && arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[curr] > arr[left]) {
                break;
            } else {
                int swap = arr[curr];
                arr[curr] = arr[left];
                arr[left] = swap;
            }
            curr = left;
            left = 2 * curr + 1;
        }
    }


    public static void heapSortAsc(int[] arr) {
        int len = arr.length;
        //构造大顶堆
        for (int i = len / 2 - 1; i > -1; i--) {
            maxHeapSink(arr, i, len - 1);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = len - 1; i > 0; i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;
            maxHeapSink(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 6, 9, 2, 10, 12, 15, 2, 8, 22};
        heapSortAsc(arr);
        System.out.println(Arrays.toString(arr));
    }
}
