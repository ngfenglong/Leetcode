import java.util.*;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    class Solution {
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<String> list = new ArrayList<>();

            int curr = (groups[0] + 1) % 2;
            for (int i = 0; i < groups.length; i++) {
                if (groups[i] != curr) {
                    list.add(words[i]);
                    curr = groups[i];
                }
            }

            return list;
        }
    }
}