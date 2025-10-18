
/*
Problem Name: First Bad Version
Problem Number: LeetCode 278
Problem Link: https://leetcode.com/problems/first-bad-version/
*/

 /*class Solution extends VersionControl {
    // Function to find the first bad version using binary search
    public int firstBadVersion(int n) {
        int s = 1;                 // start of range
        int e = n;                 // end of range
        int badVersion = n;        // assume last version is bad

        // Binary search for first bad version
        while (s <= e) {
            int mid = s + (e - s) / 2; // avoid overflow

            if (isBadVersion(mid)) {
                badVersion = mid;   // record possible first bad version
                e = mid - 1;        // search left half
            } else {
                s = mid + 1;        // search right half
            }
        }

        return badVersion;
    }
}

/*
---------------------------------
Logic:
1. Binary search between versions 1 → n.
2. If isBadVersion(mid) = true, record mid and search left.
3. Otherwise, search right.
4. Return the first version found bad.

---------------------------------
Complexity:
- Time Complexity: O(log n)
- Space Complexity: O(1)
*/
