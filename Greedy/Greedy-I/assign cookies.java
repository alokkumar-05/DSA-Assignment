
/*
Problem Name: Assign Cookies
Platform: LeetCode
Link: https://leetcode.com/problems/assign-cookies/
*/

import java.util.*;

 class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0;
        while (l < s.length && r < g.length) {
            if (g[r] <= s[l]) r++; // child satisfied
            l++; // move to next cookie
        }
        return r;
    }
}

/*
---------------------------------
Logic:
1. Sort both arrays.
2. Use two pointers to assign smallest possible cookie to each child.
3. Count how many children get cookies satisfying their greed.
---------------------------------
Complexity:
- Time: O(n log n + m log m)
- Space: O(1)
*/
