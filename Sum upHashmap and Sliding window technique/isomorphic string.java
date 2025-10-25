
import java.util.*;

/*
Problem Name: Isomorphic Strings
Platform: LeetCode
Link: https://leetcode.com/problems/isomorphic-strings/
*/

 class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check mapping s to t
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            // Check mapping t to s
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }
}

/*
---------------------------------
Logic:
1. Use two HashMaps to track s->t and t->s mappings.
2. Ensure every mapping is consistent.
3. Return true if all characters satisfy isomorphism.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
