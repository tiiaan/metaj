package com.tiiaan.tbm.metaj.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class QuickSort {


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[i];
                arr[i] = arr[index];
                arr[index] = swap;
                index++;
            }
        }
        int swap = arr[pivot];
        arr[pivot] = arr[index - 1];
        arr[index - 1] = swap;
        int partitionIndex = index - 1;
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 6, 9, 2, 10, 12, 15, 2, 8, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
