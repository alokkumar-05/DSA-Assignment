
import java.util.ArrayList;
import java.util.List;

/*
Problem Name: Permutations
Platform: LeetCode
Link: https://leetcode.com/problems/permutations/
*/

 class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        heapPermutation(nums, nums.length, result);
        return result;
    }

    private void heapPermutation(int[] nums, int n, List<List<Integer>> result) {
        if (n == 1) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm); // add current permutation
        } else {
            for (int i = 0; i < n; i++) {
                heapPermutation(nums, n - 1, result);

                if (n % 2 == 0) swap(nums, i, n - 1);
                else swap(nums, 0, n - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }
}

/*
---------------------------------
Logic:
1. Use Heap's Algorithm to generate permutations recursively.
2. Swap elements based on parity.
3. Collect all permutations in result list.
---------------------------------
Complexity:
- Time: O(n! * n)
- Space: O(n! * n)
*/
