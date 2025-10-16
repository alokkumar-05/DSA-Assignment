package String;

/*
Problem Name: Remove Duplicate Characters
Problem Link: https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1
Description: Given a string with possible duplicate characters, remove all duplicates 
             and return the resultant string in original order.
*/

import java.util.HashSet;

class Solution {
    public static String removeDuplicates(String s) {
        HashSet<Character> seen = new HashSet<>(); // Store unique characters
        StringBuilder result = new StringBuilder(); // Build the final string

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Test the solution
    public static void main(String[] args) {
        String s = "geEksforGEeks";
        System.out.println("Original String: " + s);
        System.out.println("After Removing Duplicates: " + removeDuplicates(s));
    }
}

/*
---------------------------------
Logic:
1. Use a HashSet to keep track of characters already seen.
2. Append only unseen characters to the result.
3. Return the final string after traversal.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
