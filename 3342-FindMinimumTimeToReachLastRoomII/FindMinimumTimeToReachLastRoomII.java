import java.util.*;

public class FindMinimumTimeToReachLastRoomII {
    class Solution {
        final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        public int minTimeToReach(int[][] moveTime) {
            int m = moveTime.length;
            int n = moveTime[0].length;
            boolean[][] dp = new boolean[m][n];

            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[2], b[2]);
                }
            });

            queue.add(new int[] { 0, 0, 0, 1 }); // x,y,time, cost

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                if (curr[0] == m - 1 && curr[1] == n - 1) {
                    return curr[2];
                }
                if (dp[curr[0]][curr[1]])
                    continue;

                dp[curr[0]][curr[1]] = true;

                int nextCost = curr[3] == 1 ? 2 : 1;

                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        queue.add(new int[] { x, y, Math.max(curr[2], moveTime[x][y]) + curr[3], nextCost });
                    }
                }

            }

            return -1;
        }
    }

}