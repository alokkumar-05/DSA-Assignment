
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Combinations
Platform: LeetCode
Link: https://leetcode.com/problems/combinations/
*/

class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        helper(n, k, 1, res, ele);
        return res;
    }

    private void helper(int n, int k, int start, List<List<Integer>> res, List<Integer> ele) {
        if (ele.size() == k) {
            res.add(new ArrayList<>(ele));
            return;
        }
        for (int i = start; i <= n; i++) {
            ele.add(i);
            helper(n, k, i + 1, res, ele);
            ele.remove(ele.size() - 1);
        }
    }
}

/*
---------------------------------
Logic:
1. Backtrack from start to n.
2. Add number to current combination.
3. Recurse and backtrack to explore all options.
---------------------------------
Complexity:
- Time: O(C(n, k) * k)
- Space: O(k)
*/
