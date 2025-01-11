import java.util.*;

class MinimumNumberOfPushesToTypeWordI {
    
    
    class Solution {
        public int minimumPushes(String word) {
            Integer[] letters = new Integer[26];
            Arrays.fill(letters,0);
            for(int i = 0 ; i < word.length(); i++){
                int idx = word.charAt(i) - 'a';
                letters[idx]++;
            }
            
            Arrays.sort(letters, Collections.reverseOrder());
            
            int i = 0;
            int min = 0;
            while(i < letters.length && letters[i] > 0){
                int buttonPressed = (i / 8) + 1;
                min += (buttonPressed * letters[i]);
                i++;
            }
            return min;
        }
    }
}
