package com.arr;

import java.util.Arrays;

/**
 * @author ng
 * @date 2019/11/19-12:50
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {112, 2, 5, 66, 6, 77, 44, -23, -4, 100, 99};
        bubboSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(binarySort(arr, 333));
    }

    private static int binarySort(int[] arr, int key) {
        int start = 0, end = arr.length - 1, mid = (arr.length + start) / 2;
        while (start <= end) {
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if (arr[mid] < key) {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        return -1;
    }

    private static void bubboSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[0];
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
