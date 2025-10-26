import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Name: Combination Sum II
Platform: LeetCode
Link: https://leetcode.com/problems/combination-sum-ii/
*/

 class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, 0, target, result, temp);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || start == candidates.length) return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicates
            if (candidates[i] > target) break;

            temp.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], result, temp);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}

/*
---------------------------------
Logic:
1. Sort candidates to handle duplicates.
2. Backtrack to include/exclude elements.
3. Skip duplicates at same recursion depth.
4. Backtrack after recursion.
---------------------------------
Complexity:
- Time: Exponential
- Space: O(k)
*/
