import java.util.HashMap;
import java.util.Arrays;

/*
Problem Name: Two Sum
Problem Link: https://leetcode.com/problems/two-sum/
*/

 class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){
            int req = target - nums[i];
            if(map.containsKey(req)){
                ans[0] = i;
                ans[1] = map.get(req);
            } else {
                map.put(nums[i], i);
            }
        }

        return ans;
    }

}

/*
---------------------------------
Logic:
1. Traverse array, calculate required value = target - current.
2. Check if required exists in map.
3. Return indices if found; else store value in map.
---------------------------------
Complexity:
- Time: O(n)
- Space: O(n)
---------------------------------
*/
 
