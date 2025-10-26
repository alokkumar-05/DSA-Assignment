
import java.util.Arrays;

/*
Problem Name: Activity Selection Problem
Platform: GFG / LeetCode
Link: https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1
*/

 class ActivitySelection {

    static class Activity {
        int start, finish;
        Activity(int s, int f) { start = s; finish = f; }
    }

    public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        Activity[] acts = new Activity[n];
        for (int i = 0; i < n; i++) acts[i] = new Activity(start[i], finish[i]);
        
        Arrays.sort(acts, (a,b) -> a.finish - b.finish);
        
        int count = 1, lastFinish = acts[0].finish;
        for (int i = 1; i < n; i++) {
            if (acts[i].start > lastFinish) {
                count++;
                lastFinish = acts[i].finish;
            }
        }
        return count;
    }
}

/*
---------------------------------
Logic:
1. Sort activities by finish time.
2. Always pick first activity.
3. Pick next activity if start > lastFinish.
---------------------------------
Complexity:
- Time: O(n log n)
- Space: O(n)
*/
