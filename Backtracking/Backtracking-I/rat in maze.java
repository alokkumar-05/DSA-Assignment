
import java.util.*;

/*
Problem Name: Escape a Large Maze
Platform: LeetCode
Link: https://leetcode.com/problems/escape-a-large-maze/
*/

 class EscapeLargeMaze {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int LIMIT;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) blockedSet.add((long) b[0] << 20 | b[1]);

        LIMIT = blocked.length * (blocked.length - 1) / 2;
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited.add((long) start[0] << 20 | start[1]);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) return true;
            if (visited.size() > LIMIT) return true;

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx >= 0 && nx < 1_000_000 && ny >= 0 && ny < 1_000_000) {
                    long code = ((long) nx << 20) | ny;
                    if (!visited.contains(code) && !blockedSet.contains(code)) {
                        visited.add(code);
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        return false;
    }
}
