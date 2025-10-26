
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Subsets
Platform: LeetCode
Link: https://leetcode.com/problems/subsets/
*/

 class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(0, nums, ans, res); // backtracking from index 0
        return res;
    }

    private List<List<Integer>> helper(int idx, int[] nums, List<Integer> ans, List<List<Integer>> res) {
        res.add(new ArrayList<>(ans)); // add current subset
        for (int i = idx; i < nums.length; i++) {
            ans.add(nums[i]); // include nums[i]
            helper(i + 1, nums, ans, res); // recurse
            ans.remove(ans.size() - 1); // backtrack
        }
        return res;
    }
}

/*
---------------------------------
Logic:
1. Use backtracking to include/exclude elements.
2. Add current subset to result.
3. Recurse and backtrack to explore all subsets.
---------------------------------
Complexity:
- Time: O(2^n * n)
- Space: O(n)
*/
