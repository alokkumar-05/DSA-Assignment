package Recursion;

class Solution {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);        // Sort left half
            mergeSort(arr, mid + 1, right);   // Sort right half
            merge(arr, left, mid, right);     // Merge
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int i = 0; i < n2; i++) rightArr[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

}

/*
---------------------------------
Logic:
1. Divide array into halves recursively.
2. Sort each half.
3. Merge sorted halves.
---------------------------------
Complexity:
- Time Complexity: O(n log n)
- Space Complexity: O(n)
*/
