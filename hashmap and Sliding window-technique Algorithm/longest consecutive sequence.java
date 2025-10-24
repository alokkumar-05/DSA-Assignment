
import java.util.HashSet;
import java.util.Set;

/*
Problem Name: Longest Consecutive Sequence
Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/
*/

 class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}

/*
---------------------------------
Logic:
1. Store numbers in a HashSet for O(1) lookup.
2. Start sequence counting from numbers without predecessor.
3. Update maximum streak length.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/
