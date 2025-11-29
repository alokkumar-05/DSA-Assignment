import java.util.*;
class LCS {
    /*-----------------------------------------------------------
     * 1. Memoization (Top Down)
     *-----------------------------------------------------------*/
    public int lcsMemo(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, m - 1, s1, s2, dp);
    }

    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2, dp);

        int left = solve(i - 1, j, s1, s2, dp);
        int right = solve(i, j - 1, s1, s2, dp);

        return dp[i][j] = Math.max(left, right);
    }

    /*-----------------------------------------------------------
     * 2. Tabulation (Bottom Up)
     *-----------------------------------------------------------*/
    public int lcsTab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    /*-----------------------------------------------------------
     * 3. Space Optimized LCS (Best)
     *-----------------------------------------------------------*/
    public int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}

/*
---------------------------------------------------------
Logic Summary:
If match → 1 + lcs(i-1, j-1)
Else → max(left, right)
---------------------------------------------------------
Time: O(n*m)
Space: Tab → O(n*m), Optimized → O(m)
---------------------------------------------------------
*/
