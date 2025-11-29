import java.util.Arrays;

class WildcardMatching {

    /*-----------------------------------------------------------
     * 1. DP Memoization (Top-Down)
     *-----------------------------------------------------------*/
    public boolean isMatchMemo(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, m - 1, s, p, dp) == 1;
    }

    private int solve(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (j < 0) return 0;
        if (i < 0) return isAllStars(p, j) ? 1 : 0;

        if (dp[i][j] != -1) return dp[i][j];

        char a = s.charAt(i), b = p.charAt(j);

        if (a == b || b == '?')
            return dp[i][j] = solve(i - 1, j - 1, s, p, dp);

        if (b == '*')
            return dp[i][j] = (solve(i, j - 1, s, p, dp) == 1 ||
                                solve(i - 1, j, s, p, dp) == 1) ? 1 : 0;

        return dp[i][j] = 0;
    }

    private boolean isAllStars(String p, int j) {
        for (int k = 0; k <= j; k++)
            if (p.charAt(k) != '*') return false;
        return true;
    }

    /*-----------------------------------------------------------
     * 2. DP Tabulation (Bottom-Up)
     *-----------------------------------------------------------*/
    public boolean isMatchTab(String s, String p) {
        int n = s.length(), m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++)
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = s.charAt(i - 1), b = p.charAt(j - 1);

                if (a == b || b == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (b == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}

/*
---------------------------------------------------------
Time Complexity:
Memoization: O(n*m)
Tabulation : O(n*m)

Space Complexity:
Memo: O(n*m)
Tab: O(n*m)
---------------------------------------------------------
*/
