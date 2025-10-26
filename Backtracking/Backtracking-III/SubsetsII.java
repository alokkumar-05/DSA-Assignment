
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Name: Subsets II
Platform: LeetCode
Link: https://leetcode.com/problems/subsets-ii/
*/

 class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // add current subset

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // skip duplicates

            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}

/*
---------------------------------
Logic:
1. Sort array to handle duplicates.
2. Backtrack to add/exclude elements.
3. Skip duplicates at the same recursion depth.
4. Backtrack after recursion.
---------------------------------
Complexity:
- Time: O(2^n * n)
- Space: O(n)
*/

