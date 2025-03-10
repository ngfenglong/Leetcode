import java.util.*;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    class Solution {
        Set<Character> vowels = new HashSet<>();
        HashMap<Character, Integer> vowelsCount = new HashMap<>();
        public long countOfSubstrings(String word, int k) {
            setUpVowelsSetAndMap();
            
            int consonantsCount = 0;
            int start = 0;
            int end = start;
    
            boolean hasAllVowels = false;
    
            int[] nextConsonants = new int[word.length()];
            int nextConsonantIdx = word.length();
            for(int i = nextConsonants.length - 1; i >= 0; i--){
                nextConsonants[i] = nextConsonantIdx;
                if(!vowels.contains(word.charAt(i))){
                    nextConsonantIdx = i;
                }
            }
    
    
            long ans = 0l;
            while(end < word.length()){
                char c = word.charAt(end);
                if(vowels.contains(c)){
                    vowelsCount.put(c, vowelsCount.get(c) + 1);
                    hasAllVowels = containsAllVowel();
                }
                else{
                    consonantsCount++;
                }
    
    
                while(consonantsCount > k){
                    char startC = word.charAt(start);
                    if(vowels.contains(startC)){
                        int currCount = vowelsCount.get(startC);
                        vowelsCount.put(startC, currCount - 1);
                        if(currCount == 1) hasAllVowels = false;
                    }
                    else {
                        consonantsCount--;
                    }
                    start++;
                }
    
    
                while(hasAllVowels && start <= end && consonantsCount == k){
                    ans += (long)(nextConsonants[end] - end);
                    char startC = word.charAt(start);
                    if(vowels.contains(startC)){
                        int currCount = vowelsCount.get(startC);
                        vowelsCount.put(startC, currCount - 1);
                        if(currCount == 1) hasAllVowels = false;
                    }
                    else {
                        consonantsCount--;
                    }
                    start++;
                }
    
                end++;
            }
    
    
    
            return ans;
        }
        
        private void setUpVowelsSetAndMap(){
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
    
            for(Character c: vowels){
                vowelsCount.put(c, 0);
            }
            
        }
    
        private boolean containsAllVowel(){
            for(Character c: vowels){
                if(vowelsCount.getOrDefault(c, 0) <= 0) return false;
            }
    
            return true;
        }
    }
}