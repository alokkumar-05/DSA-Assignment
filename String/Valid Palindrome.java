package String;

/*
Problem Name: Valid Palindrome
Problem Number: LeetCode 125
Problem Link: https://leetcode.com/problems/valid-palindrome/
*/

 class Solution {
    public boolean isPalindrome(String s) {
        // Convert to lowercase to ignore case sensitivity
        s = s.toLowerCase();

        StringBuilder str = new StringBuilder();

        // Keep only alphanumeric characters
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }

        int left = 0, right = str.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

/*
---------------------------------
Logic:
1. Convert to lowercase and remove all non-alphanumeric characters.
2. Compare characters from both ends using two-pointer approach.
3. If all characters match, it is a palindrome.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
