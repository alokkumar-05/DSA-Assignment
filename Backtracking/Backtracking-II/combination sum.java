import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Combination Sum
Platform: LeetCode
Link: https://leetcode.com/problems/combination-sum/
*/

 class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, result, temp);
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target < 0 || index == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Include current candidate
        temp.add(candidates[index]);
        helper(candidates, index, target - candidates[index], result, temp);
        temp.remove(temp.size() - 1); // backtrack

        // Exclude current candidate
        helper(candidates, index + 1, target, result, temp);
    }
}

/*
---------------------------------
Logic:
1. Backtrack to include/exclude candidates.
2. Reuse elements for target sum.
3. Backtrack after recursion.
---------------------------------
Complexity:
- Time: Exponential
- Space: O(k)
*/
