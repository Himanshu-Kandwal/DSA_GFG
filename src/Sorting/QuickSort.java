package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 7, 90, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr.length <= 1) return;

        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        quickSort(arr, leftIdx, rightIdx);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partitionIdx = partition2(arr, left, right);
        quickSort(arr, left, partitionIdx - 1);
        quickSort(arr, partitionIdx + 1, right);
    }


    // Utility function to swap elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition2(int a[], int si, int ei) {
        int pivot = a[si];
        int countSmaller = 0;

        // Count elements smaller than or equal to pivot
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] <= pivot) {
                countSmaller++;
            }
        }

        // Find pivot index and place pivot there
        int pivotIndex = countSmaller + si;
        a[si] = a[pivotIndex];
        a[pivotIndex] = pivot;

        // Arrange elements around pivot
        int i = si, j = ei;
        while (i < pivotIndex && j > pivotIndex) {
            if (a[i] <= pivot) {
                i++;
            } else if (a[j] > pivot) {
                j--;
            } else {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

}
