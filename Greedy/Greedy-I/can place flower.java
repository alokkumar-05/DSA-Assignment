
/*
Problem Name: Can Place Flowers
Platform: LeetCode
Link: https://leetcode.com/problems/can-place-flowers/
*/

 class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    n--;
                    if (n <= 0) return true;
                }
            }
        }
        return n <= 0;
    }
}

/*
---------------------------------
Logic:
1. Check each plot if it and neighbors are empty.
2. Plant flower if possible and decrement n.
3. Return true if n <= 0.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
