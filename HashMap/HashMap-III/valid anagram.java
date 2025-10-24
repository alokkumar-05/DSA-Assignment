
import java.util.HashMap;
import java.util.Map;

/*
Problem Name: Valid Anagram
Problem Link: https://leetcode.com/problems/valid-anagram/
*/
 class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        return mapS.equals(mapT);
    }
}

/*
---------------------------------
Logic:
1. Count character frequency in both strings using HashMaps.
2. Compare both maps to check if strings are anagrams.
---------------------------------
Complexity:
- Time: O(n + m)
- Space: O(n + m)
---------------------------------
*/
