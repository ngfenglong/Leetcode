public class TotalCharactersInStringAfterTransformationsI {
    class Solution {
        private static final int MODULO = 1000000007;

        public int lengthAfterTransformations(String s, int t) {
            int[] counts = new int[26];

            for (int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - 'a';
                counts[val]++;
            }

            for (int i = 0; i < t; i++) {
                int[] newCounts = new int[26];
                newCounts[0] = counts[25];
                newCounts[1] = (counts[0] + counts[25]) % MODULO;
                for (int j = 2; j < 26; j++) {
                    newCounts[j] = counts[j - 1];
                }
                counts = newCounts;
            }

            int ans = 0;
            for (int i = 0; i < counts.length; i++) {
                ans += counts[i];
                ans = ans % MODULO;
            }

            return ans;
        }
    }
}