
import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Name: Subsets II
Platform: LeetCode / GFG
Link: https://leetcode.com/problems/subsets-ii/
*/
 class SubsetsWithDuplicates {

    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // sort to handle duplicates
        backtrack(0, arr, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> tempList, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(tempList)); // add current subset
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]); // include nums[i]
            backtrack(i + 1, nums, tempList, result); // recurse
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}

/*
---------------------------------
Logic:
1. Sort array to handle duplicates.
2. Use backtracking to include/exclude elements.
3. Skip duplicates at same recursion depth.
---------------------------------
Complexity:
- Time: O(2^n * n)
- Space: O(n)
*/
