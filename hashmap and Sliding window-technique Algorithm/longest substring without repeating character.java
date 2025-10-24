/*
Problem Name: Longest Substring Without Repeating Characters
Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}

/*
---------------------------------
Logic:
1. Use sliding window and HashSet to track current substring.
2. Expand window until duplicate appears, then shrink from left.
3. Update maximum length during the process.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(min(n,26))
*/
