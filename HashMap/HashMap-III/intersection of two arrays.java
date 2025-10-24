
import java.util.HashMap;
import java.util.ArrayList;

/*
Problem Name: Intersection of Two Arrays
Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/
*/

 class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, true); // store nums1 elements
        }
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num)) {
                result.add(num);
                map.put(num, false); // ensure uniqueness
            }
        }
        
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        
        return resArr;
    }
}

/*
---------------------------------
Logic:
1. Store elements of nums1 in HashMap.
2. Traverse nums2 and add common unique elements to result.
3. Convert result to int[].
---------------------------------
Complexity:
- Time: O(n + m)
- Space: O(n)
---------------------------------
*/
