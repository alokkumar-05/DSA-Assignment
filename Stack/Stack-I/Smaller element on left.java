import java.util.TreeSet;

/*
Problem Name: Smallest Element on Left
*/

 class Complete {
    // Function to find the greatest element smaller than current element on left
    public static int[] Smallestonleft(int arr[], int n) {
        int[] result = new int[n];
        TreeSet<Integer> ts = new TreeSet<>(); // Stores previous elements in sorted order

        for (int i = 0; i < n; i++) {
            // Find the floor of (arr[i] - 1), i.e., largest element smaller than arr[i]
            Integer floor = ts.floor(arr[i] - 1);
            result[i] = (floor == null) ? -1 : floor; // If no smaller element exists, assign -1
            ts.add(arr[i]); // Add current element for future comparisons
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Use TreeSet to maintain left-side elements in sorted order.
2. For each element, find the largest element smaller than it using floor().
3. If no smaller element exists, assign -1.
4. Add current element to TreeSet.
5. Return result array.

---------------------------------
Complexity:
- Time Complexity: O(n log n)
- Space Complexity: O(n)
*/
