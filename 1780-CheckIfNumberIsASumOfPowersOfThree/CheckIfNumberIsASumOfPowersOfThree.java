public class CheckIfNumberIsASumOfPowersOfThree {
    class Solution {
        public boolean checkPowersOfThree(int n) {
            return isSumOfThree(n);
        }

        private boolean isSumOfThree(int n) {
            if (n == 0)
                return true;

            int p = 0;
            while ((int) Math.pow(3, p + 1) <= n)
                p++;

            if (n >= (2 * ((int) Math.pow(3, p))))
                return false;

            return isSumOfThree(n - (int) Math.pow(3, p));
        }
    }

}