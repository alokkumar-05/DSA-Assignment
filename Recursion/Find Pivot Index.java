package Recursion;

 class Solution {
    // Function to find pivot index recursively
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num; // Compute total sum
        return findPivot(nums, 0, 0, totalSum); // Start recursion
    }

    // Recursive helper function
    private static int findPivot(int[] nums, int index, int leftSum, int totalSum) {
        if (index == nums.length) return -1; // Base case
        if (leftSum == totalSum - leftSum - nums[index]) return index; // Pivot found
        return findPivot(nums, index + 1, leftSum + nums[index], totalSum); // Recurse
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index: " + pivotIndex(nums));
    }
}

/*
---------------------------------
Logic:
1. Compute total sum of array.
2. Use recursion with index and leftSum.
3. Base case: index == nums.length -> return -1.
4. Check leftSum == totalSum - leftSum - nums[index].
---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n) (recursion stack)
*/
