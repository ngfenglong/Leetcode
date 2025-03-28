import java.util.*;

public class MaximumNumberOfPointsFromGridQueries {
    class Solution {
        final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        public int[] maxPoints(int[][] grid, int[] queries) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] sortedQueries = new int[queries.length][2]; // {amount, index}
            for (int i = 0; i < queries.length; i++) {
                sortedQueries[i][0] = queries[i];
                sortedQueries[i][1] = i;
            }

            Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

            // []{cell val, i, j} ordered grid cell to visit
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

            int[] ans = new int[queries.length];
            boolean[][] visited = new boolean[m][n];
            pq.add(new int[] { grid[0][0], 0, 0 });

            int count = 0;
            for (int idx = 0; idx < sortedQueries.length; idx++) {
                while (!pq.isEmpty() && pq.peek()[0] < sortedQueries[idx][0]) {
                    int[] cell = pq.poll();

                    int i = cell[1];
                    int j = cell[2];

                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        count++;

                        for (int[] dir : DIRECTIONS) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 &&
                                    y >= 0 &&
                                    x < m &&
                                    y < n &&
                                    !visited[x][y]) {
                                pq.add(new int[] { grid[x][y], x, y });
                            }
                        }
                    }
                }
                ans[sortedQueries[idx][1]] = count;
            }

            return ans;
        }
    }
}