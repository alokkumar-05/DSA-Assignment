
/*
Problem Name: Lemonade Change
Platform: LeetCode
Link: https://leetcode.com/problems/lemonade-change/
*/

class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}

/*
---------------------------------
Logic:
1. Track $5 and $10 bills.
2. For $10 bill, give $5 as change.
3. For $20 bill, prefer $10 + $5, else 3*$5. Fail if impossible.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(1)
*/
