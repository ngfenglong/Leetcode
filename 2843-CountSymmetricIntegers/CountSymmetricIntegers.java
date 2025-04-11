public class CountSymmetricIntegers {
    class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int count = 0;
            for (int i = low; i <= high; i++) {
                if (i < 10) {
                    i = 9;
                    continue;
                }

                else if (i >= 100 && i <= 999) {
                    i = 999;
                    continue;
                }

                if (isSymmetric("" + i))
                    count++;
            }

            return count;
        }

        private boolean isSymmetric(String s) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length() / 2; i++) {
                left += Integer.parseInt("" + s.charAt(i));
                right += Integer.parseInt("" + s.charAt(s.length() - 1 - i));
            }

            return left == right;
        }
    }
}