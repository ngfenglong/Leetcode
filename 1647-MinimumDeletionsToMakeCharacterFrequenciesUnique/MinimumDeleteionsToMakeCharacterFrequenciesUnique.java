import java.util.*;

class MinimumDeleteionsToMakeCharacterFrequenciesUnique {
    
    class Solution {
        public int minDeletions(String s) {
            int[] frequencies = new int[26];
            
            for(int i = 0; i < s.length(); i++){
                frequencies[(s.charAt(i) - 'a')]++;
            }
            
            int count = 0;
            Set<Integer> check = new HashSet<>();
            
            for(int i = 0; i < 26; i++){
                int frequency = frequencies[i];
                while(frequency > 0 && check.contains(frequency)){
                    frequency--;
                    count++;
                }    
                
                check.add(frequency);
                
            }
            
            return count;
        }
    }
}
