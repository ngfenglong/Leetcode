import java.util.*;

public class FindMinimumTimeToReachLastRoomI {
    class Solution {
        final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        public int minTimeToReach(int[][] moveTime) {
            int m = moveTime.length;
            int n = moveTime[0].length;
            boolean[][] visited = new boolean[m][n];

            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[2], b[2]);
                }
            });

            queue.add(new int[] { 0, 0, 0 });

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                if (curr[0] == m - 1 && curr[1] == n - 1)
                    return curr[2];
                if (visited[curr[0]][curr[1]])
                    continue;

                visited[curr[0]][curr[1]] = true;

                for (int[] dir : DIRECTIONS) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n)
                        queue.add(new int[] { x, y, Math.max(moveTime[x][y] +
                                1, curr[2] + 1) });
                }
            }

            return -1;
        }
    }

}