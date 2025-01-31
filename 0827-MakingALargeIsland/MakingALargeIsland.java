import java.util.*;

class MakingALargeIsland {
    class Solution {
        HashMap<Integer, Integer> landSizes = new HashMap<>();
        int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int n;

        public int largestIsland(int[][] grid) {
            this.n = grid.length;

            if (this.n == 1)
                return 1;

            int landId = 2; // 1 is used as default land
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        landSizes.put(landId, checkIslandSizes(i, j, grid, landId));
                        landId++;
                    }
                }
            }

            if (landId == 2)
                return 1;

            if (landId == 3)
                return landSizes.get(2) == n * n ? landSizes.get(2) : landSizes.get(2) + 1;

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int count = 1;
                        Set<Integer> neighbourLands = new HashSet<>();

                        for (int[] d : DIRECTIONS) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] != 0) {
                                neighbourLands.add(grid[x][y]);
                            }
                        }

                        for (Integer id : neighbourLands) {
                            count += landSizes.get(id);
                        }

                        max = Math.max(max, count);
                    }
                }
            }

            return max;
        }

        private int checkIslandSizes(int i, int j, int[][] grid, int landId) {
            if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1)
                return 0;

            grid[i][j] = landId;

            int count = 1;
            for (int[] d : DIRECTIONS) {
                int x = i + d[0];
                int y = j + d[1];

                count += checkIslandSizes(x, y, grid, landId);
            }

            return count;
        }
    }
}
