
class PalindromicSubstringsDP {

    /*-----------------------------------------------------------
     * DP Table: dp[i][j] = true if substring s[i...j] is palindrome
     *-----------------------------------------------------------*/
    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // g = gap (length difference between i and j)
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0) {
                    // Single character → always palindrome
                    dp[i][j] = true;
                }
                else if (g == 1) {
                    // Two characters → palindrome if both equal
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    // Check both ends + inside should be palindrome
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}

/*
---------------------------------------------------------
Logic Summary:
dp[i][j] = true if substring s[i..j] is palindrome.

Cases:
g=0 → always true
g=1 → check equality
g>=2 → check ends + dp[i+1][j-1]

---------------------------------------------------------
Time Complexity:  O(n²)
Space Complexity: O(n²)
---------------------------------------------------------
*/
