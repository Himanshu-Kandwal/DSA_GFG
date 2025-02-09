package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 5, 7, 90, -10, 10, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //T(N log N), S(Log N) for recursion
    private static void quickSort(int[] arr) {
        if (arr.length <= 1) return;

        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        quickSort(arr, leftIdx, rightIdx);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partitionIdx = partition(arr, left, right); //partition index is the index which has element in it's correct position
        quickSort(arr, left, partitionIdx - 1); //so we sort array from 0 to partitionIdx-1
        quickSort(arr, partitionIdx + 1, right); //and partitionIdx+1 to right
    }


    // Utility function to swap elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*

    Function to take a "pivot element" to it's correct position relative to all element,
    and make sure all element left to pivot element are smaller and all towards right are greater than this
    and return "pivot idx" where it has saved pivot element.

     */
    static int partition(int[] arr, int si, int ei) { //si =startIdx, ei=endIdx

        int pivotElement = arr[si]; //pivot element which will be moved to it's correct position as per position in sorted array

        //count how many elements are smaller/equal than pivotElement, it starts at i=si+1 , because "si" itself is the chosen pivot element , in the beginning
        int countSmaller = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i] <= pivotElement) { //we count equal element to pivot also , so we can deal with duplicates
                countSmaller++;
            }
        }

        //moving pivotElement to it's correct position
        int pivotIdx = si + countSmaller; // we will point to index right after place of all
        swap(arr, si, pivotIdx);

        //check if all elements in left of pivotIdx smaller than pivotElement and right of pivotIdx are greater,
        //if not then swap

        int l = si; //leftIdx
        int r = ei; //rightIdx
        while (l < pivotIdx || r > pivotIdx) { //if any pointer reaches pivotIdx , it means we have made all left of pivotidx smaller than pivotElement and all element right of pivotIdx are greater
            if (arr[l] <= pivotElement) { //if leftIdx has smaller or equal element to pivot element, we just move leftIdx and do nothing, <= so we can deal with smaller as well as duplicate in this case
                l++;
            } else if (arr[r] > pivotElement) {//if element at rightIdx has larger element than pivotElement, we will move right, and do nothing
                r--;
            } else { //both leftIdx and rightIdx don't have right elements i.e leftIdx has larger and rightIdx has smaller element than pivot
                //so we need to swap them, and move both pointers
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        //finally return pivotIdx i.e partitionIdx
        return pivotIdx;
    }

}
