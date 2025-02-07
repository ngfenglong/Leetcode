import java.util.*;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            HashMap<Integer, Integer> ballColor = new HashMap<>();
            HashMap<Integer, Integer> colorListCount = new HashMap<>();

            int count = 0;

            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int ball = queries[i][0];
                int color = queries[i][1];

                int prevBallColor = ballColor.getOrDefault(ball, -1);

                ballColor.put(ball, color);

                // Update previous count
                if (prevBallColor >= 0) {
                    int prevColorCount = colorListCount.getOrDefault(prevBallColor, 0);

                    if (prevColorCount > 0) {
                        prevColorCount--;
                        colorListCount.put(prevBallColor, prevColorCount);
                        if (prevColorCount == 0)
                            count--;
                    }
                }

                int currColorCount = colorListCount.getOrDefault(color, 0);

                if (currColorCount == 0)
                    count++;

                currColorCount++;
                colorListCount.put(color, currColorCount);

                ans[i] = count;
            }
            return ans;
        }
    }

}