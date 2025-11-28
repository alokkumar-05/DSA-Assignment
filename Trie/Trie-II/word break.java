
import java.util.*;

 class Solution {

    /*
    Problem Name: Word Break
    Platform: LeetCode (139)
    Difficulty: Medium
    Link: https://leetcode.com/problems/word-break/
    */

    public boolean wordBreak(String s, List<String> wordDict) {
        //  Store words in a HashSet for fast lookup
        Set<String> set = new HashSet<>(wordDict);

        //  DP array where dp[i] means substring s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string

        //  Fill dp array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

/*
----------------------------------------
Logic Summary:
1. Use DP where dp[i] indicates if prefix s[0...i-1] can be segmented.
2. Check every partition (j, i) such that s[j...i-1] ∈ wordDict.
3. If dp[j] is true, mark dp[i] = true.
4. Return dp[n].
----------------------------------------
Complexity:
Time: O(n²)
Space: O(n)
----------------------------------------
*/