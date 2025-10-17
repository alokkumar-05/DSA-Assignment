import java.util.Stack;

/*
Problem Name: Asteroid Collision
Problem Number: LeetCode 735
Problem Link: https://leetcode.com/problems/asteroid-collision/
*/

 class Solution {
    // Function to simulate asteroid collisions
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // Collision condition: current asteroid moving left, top moving right
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (Math.abs(a) > top) {
                    // Current asteroid destroys the top one
                    stack.pop();
                } else if (Math.abs(a) == top) {
                    // Both destroy each other
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid destroyed
                    destroyed = true;
                    break;
                }
            }

            // If asteroid survived, push to stack
            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack to array (final state)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

/*
---------------------------------
Logic:
1. Use stack to store moving asteroids.
2. Handle collision only when top moves right and current moves left.
3. Compare sizes:
   - |a| > top → pop top.
   - |a| == top → both destroyed.
   - |a| < top → current destroyed.
4. Push survivors and return stack as array.

---------------------------------
Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)
*/
