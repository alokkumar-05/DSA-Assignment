
import java.util.*;

/*
Problem Name: Find All Anagrams in a String
Platform: LeetCode
Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

 class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26]; 
        int[] sCount = new int[26]; 

        for (char c : p.toCharArray()) pCount[c - 'a']++;

        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= windowSize) sCount[s.charAt(i - windowSize) - 'a']--;

            if (Arrays.equals(sCount, pCount)) result.add(i - windowSize + 1);
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Use sliding window of size p.length().
2. Maintain frequency arrays for window and p.
3. Compare arrays to find anagrams.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(26) ~ O(1)
*/
