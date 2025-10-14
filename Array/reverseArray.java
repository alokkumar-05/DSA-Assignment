package Array;

/*
Problem Name: Reverse the Array
Problem Link: https://www.naukri.com/code360/problems/reverse-the-array_1262298
*/

import java.util.*;

class Solution {
    // Function to reverse the array after index m
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        int start = m + 1;             // start index after m
        int end = arr.size() - 1;      // last index

        // Swap elements until the pointers meet
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
}

/*
---------------------------------
 Logic:
1. Go to the (m + 1) index in the ArrayList.
2. Swap the element at (m + 1) index with the element at (n - 1) index.
3. Increment the left pointer (m + 1) and decrement the right pointer (n - 1) after each swap.
4. Continue this process until the pointers meet or cross (i.e., till the middle of that section).
5. Beyond that, swapping would restore the original order again.

---------------------------------
 Complexity:
- Time Complexity: O(n - m - 1) → only traverse elements after index m.
- Space Complexity: O(1) → in-place reversal, no extra data structure.

*/
