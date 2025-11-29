class LongestPalSubstring {

    /*-----------------------------------------------------------
     * 1. Expand Around Center (Best Method)
     *-----------------------------------------------------------*/
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int len1 = expand(s, i, i);

            // Even-length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*-----------------------------------------------------------
     * 2. DP Method (Tabulation)
     *-----------------------------------------------------------*/
    public String longestPalindromeDP(String s) {
        int n = s.length();
        if (n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, start = 0;

        // Gap based DP
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0) {
                    dp[i][j] = true;
                } 
                else if (g == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } 
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && (g + 1) > maxLen) {
                    maxLen = g + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

/*
---------------------------------------------------------
Logic Summary:
1️⃣ Expand → Check palindrome from center.
2️⃣ DP → dp[i][j] true if:
       s[i] == s[j] AND dp[i+1][j-1] true

Gap method ensures smaller substrings solved first.
---------------------------------------------------------
Time Complexity:
Expand: O(n²)
DP:     O(n²)

Space:
Expand: O(1)
DP:     O(n²)
---------------------------------------------------------
*/
