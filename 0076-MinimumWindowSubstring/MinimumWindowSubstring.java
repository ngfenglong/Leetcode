import java.util.*;

public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length())
                return "";

            HashMap<Character, Integer> tCharsHM = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                tCharsHM.put(t.charAt(i), tCharsHM.getOrDefault(t.charAt(i), 0) + 1);
            }

            String ans = "";
            int minLen = s.length() + 1;
            int end = 0;
            int start = 0;
            int tUniqueKey = tCharsHM.keySet().size();
            while (end < s.length()) {
                char endC = s.charAt(end);
                if (tCharsHM.containsKey(endC)) {
                    tCharsHM.put(endC, tCharsHM.get(endC) - 1);
                    if (tCharsHM.get(endC) == 0)
                        tUniqueKey--;
                }

                while (tUniqueKey == 0 && start <= end) {
                    char startC = s.charAt(start);
                    if ((end - start + 1) < minLen) {
                        minLen = end - start + 1;
                        ans = s.substring(start, end + 1);
                    }

                    if (tCharsHM.containsKey(startC)) {
                        if (tCharsHM.get(startC) == 0)
                            tUniqueKey++;
                        tCharsHM.put(startC, tCharsHM.get(startC) + 1);
                    }
                    start++;
                }

                end++;
            }

            return ans;
        }
    }
}