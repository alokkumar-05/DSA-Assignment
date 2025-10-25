
import java.util.ArrayList;

/*
Problem Name: Build Max Heap
Data Structure: Heap / ArrayList
*/

 class MaxHeap {

    private static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i;       
        int left = 2 * i + 1;  
        int right = 2 * i + 2; 

        if (left < n && arr.get(left) > arr.get(largest)) largest = left;
        if (right < n && arr.get(right) > arr.get(largest)) largest = right;

        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            heapify(arr, n, largest);
        }
    }

    public static ArrayList<Integer> buildHeap(ArrayList<Integer> arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        return arr;
    }
}

/*
---------------------------------
Logic:
1. heapify() compares parent with left and right, swap largest, recursively heapify.
2. buildHeap() calls heapify from last non-leaf node to root.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
