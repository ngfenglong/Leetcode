public class SolvingQuestionsWithBrainpower {
    class Solution {
        public long mostPoints(int[][] questions) {
            return solve(0, questions, new Long[questions.length]);
        }

        private long solve(int idx, int[][] questions, Long[] dp) {
            if (idx >= questions.length)
                return 0;

            if (dp[idx] != null)
                return dp[idx];

            long option1 = solve(idx + questions[idx][1] + 1, questions, dp) + questions[idx][0];
            long option2 = solve(idx + 1, questions, dp);

            dp[idx] = Math.max(option1, option2);

            return dp[idx];
        }
    }
}