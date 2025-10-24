
import java.util.HashMap;

/*
Problem Name: Bulls and Cows
Problem Link: https://leetcode.com/problems/bulls-and-cows/
*/

 class BullsAndCows {

    public static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // count bulls and store non-bull chars
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        // count cows for remaining chars
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g && map.containsKey(g) && map.get(g) > 0) {
                cows++;
                map.put(g, map.get(g) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}

/*
---------------------------------
Logic:
1. Count bulls directly where secret[i] == guess[i].
2. Store non-bull characters from secret in a HashMap.
3. Count cows for guess[i] that exists in map.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
*/

