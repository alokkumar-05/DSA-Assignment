package Recursion;

class Solution {
    // Function to count minimum moves to solve Tower of Hanoi
    public static int towerOfHanoi(int n, int from, int to, int aux) {
        if (n == 1) return 1; // Base case

        int moves1 = towerOfHanoi(n - 1, from, aux, to); // Move n-1 disks to aux
        int moves2 = 1; // Move nth disk to target
        int moves3 = towerOfHanoi(n - 1, aux, to, from); // Move n-1 disks to target

        return moves1 + moves2 + moves3; // Total moves
    }

    // Main method to test the function
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Minimum moves for " + n + " disks: " + towerOfHanoi(n, 1, 3, 2));
    }
}

/*
---------------------------------
Logic:
1. Base case: n == 1 → 1 move
2. Recursive case:
   a) Move n-1 disks to aux
   b) Move nth disk to target
   c) Move n-1 disks from aux to target
3. Return total moves
---------------------------------
Complexity:
- Time Complexity: O(2^n)
- Space Complexity: O(n) (recursion stack)
*/
