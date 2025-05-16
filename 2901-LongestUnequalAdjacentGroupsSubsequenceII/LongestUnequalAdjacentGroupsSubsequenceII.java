import java.util.*;

public class LongestUnequalAdjacentGroupsSubsequenceII {
    class Solution {
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            List<String> ans = new ArrayList<>();
            HashMap<String, List<String>> sequenceHM = new HashMap<>();
            int n = words.length;

            for (int i = n - 1; i >= 0; i--) {
                List<String> temp = new ArrayList<>();
                temp.add(words[i]);

                for (int j = i + 1; j < n; j++) { // O(n^2)
                    if (groups[i] != groups[j] && withinValidHammingDistance(words[i], words[j])) {
                        if (temp.size() <= sequenceHM.get(words[j]).size()) {
                            temp = new ArrayList<>();
                            temp.add(words[i]);
                            temp.addAll(sequenceHM.get(words[j]));
                        }
                    }
                }

                sequenceHM.put(words[i], new ArrayList<>(temp));
                if (temp.size() > ans.size())
                    ans = temp;
            }

            return ans;
        }

        private boolean withinValidHammingDistance(String s1, String s2) {
            if (s1.length() != s2.length())
                return false;

            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i))
                    count++;

                if (count > 1)
                    return false;
            }

            return true;
        }
    }

}