package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 0, 2, 4, 10, 4, -1};
        int aux[] = new int[arr.length]; //auxilary space required to merge
        sort(arr, aux, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int aux[], int low, int high) {
        if (high <= low) return;

        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, mid + 1, high);
    }

    public static void merge(int arr[], int aux[], int l1, int r1, int l2, int r2) {
        int k = l1; //pointer for aux array

        //two pointers for backing up range of beginning of left half and end of right half of array
        int start = l1;
        int end = r2;

        while (l1 <= r1 && l2 <= r2) {
            if (arr[l1] <= arr[l2]) {
                aux[k] = arr[l1];
                l1++;
                k++;
            } else {
                aux[k] = arr[l2];
                l2++;
                k++;
            }
        }

        //first half still has some elements left
        while (l1 <= r1) {
            aux[k] = arr[l1];
            l1++;
            k++;
        }

        //second half still has some elements left

        while (l2 <= r2) {
            aux[k] = arr[l2];
            l2++;
            k++;
        }

        //copying sorted aux array back to main arr from start of left-half to end of right-half ,
        //left half array and right half array in merge sort are always adjacent i.e left half is followed by right half, so no gap in between both arrays
        while (start <= end) {
            arr[start] = aux[start];
            start++;
        }
    }
}
