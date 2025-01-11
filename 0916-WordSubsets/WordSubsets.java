import java.util.*;

class WordSubsets {
    
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            int[] subsetMaxChar = new int[26];
    
            for (String word : words2) {
                int[] temp = countCharacters(word);
                for (int i = 0; i < 26; i++) {
                    subsetMaxChar[i] = Math.max(subsetMaxChar[i], temp[i]);
                }
            }
    
            List<String> result = new ArrayList<>();
            for (String word : words1) {
                int[] wordChars = countCharacters(word);
                if (isSubset(wordChars, subsetMaxChar)) {
                    result.add(word);
                }
            }
    
            return result;
        }
    
        private int[] countCharacters(String word) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            return charCount;
        }
    
        private boolean isSubset(int[] wordChars, int[] subsetMaxChar) {
            for (int i = 0; i < 26; i++) {
                if (wordChars[i] < subsetMaxChar[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
