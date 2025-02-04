package Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 7, 90, 10};
        quickSort(arr);
    }

    private static void quickSort(int[] arr) {
        if (arr.length <= 1) return;

        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        quickSort(arr, leftIdx, rightIdx);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int partitionIdx = partition(arr, left, right);
        quickSort(arr, left, partitionIdx - 1);
        quickSort(arr, partitionIdx + 1, right);
    }

    //this function chooses an element called pivot and makes sure that all the elements left of pivot are smaller
    //all the element in right of pivot are greater than pivot
    //returns the index of pivot
    private static int partition(int[] arr, int l, int r) {
        int pivotValue = arr[r]; // Choosing the rightmost element as pivot
        int pivotIdx = l; // This will track the correct position for pivot

        for (int i = l; i < r; i++) { // Iterate from l to r-1
            if (arr[i] < pivotValue) { // If current element is smaller than pivot
                swap(arr, i, pivotIdx); // Swap it with the element at pivotIdx
                pivotIdx++; // Move pivotIdx to the right
            }
        }
        swap(arr, pivotIdx, r); // Finally, place the pivot at its correct position
        return pivotIdx; // Return the pivot index
    }

    // Utility function to swap elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
