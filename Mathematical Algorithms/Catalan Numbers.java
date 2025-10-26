

/*
Problem Name: Unique Binary Search Trees
Platform: LeetCode
Link: https://leetcode.com/problems/unique-binary-search-trees/
*/

class UniqueBSTs {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty tree
        dp[1] = 1; // single node tree

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root]; // left*right subtrees
            }
        }

        return dp[n];
    }
}

/*
---------------------------------
Logic:
1. Use DP based on Catalan numbers.
2. dp[n] = sum(dp[left] * dp[right]) for each root.
3. Base: dp[0]=1, dp[1]=1
---------------------------------
Complexity:
- Time: O(n^2)
- Space: O(n)
*/
