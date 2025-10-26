
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Subsets
Platform: LeetCode
Link: https://leetcode.com/problems/subsets/
*/

 class AllSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n; // total subsets = 2^n
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) subset.add(nums[j]); // add if j-th bit is set
            }
            result.add(subset);
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Use bitmask from 0 to 2^n - 1.
2. j-th bit set → include nums[j] in subset.
---------------------------------
Complexity:
- Time: O(n * 2^n)
- Space: O(n * 2^n)
*/
