import java.util.*;

class StringMatchingInAnArray {
    
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> matching = new ArrayList<>();
    
            for(int i = 0; i < words.length; i++){
                for(int j = 0; j < words.length; j++){
                    if(i != j){
                        String word = words[j];
                        String toCheck = words[i];
    
                        if(word.indexOf(toCheck) != -1) {
                            matching.add(toCheck);
                            break;
                        }
                    }
                }
            }   
    
            return matching;
        }
    }
}
