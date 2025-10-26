
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Permutations
Platform: LeetCode
Link: https://leetcode.com/problems/permutations/
*/
 class PermutationsBacktracking {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(nums, result, ans);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> ans) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans)); // add full permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (ans.contains(nums[i])) continue; // skip already used
            ans.add(nums[i]); // include nums[i]
            helper(nums, result, ans); // recurse
            ans.remove(ans.size() - 1); // backtrack
        }
    }
}

/*
---------------------------------
Logic:
1. Use backtracking to generate permutations.
2. Skip already used elements.
3. Backtrack after recursion.
---------------------------------
Complexity:
- Time: O(n! * n)
- Space: O(n)
*/
