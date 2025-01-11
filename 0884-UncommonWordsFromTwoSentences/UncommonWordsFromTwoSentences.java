import java.util.*;

class UncommonWordsFromTwoSentences {
    
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            HashMap<String, Integer> frequencies = new HashMap<>();
            for(String s: s1.split(" ")){
                if(!frequencies.containsKey(s)) frequencies.put(s, 1);
                else frequencies.put(s, frequencies.get(s) + 1);
            }
            
            for(String s: s2.split(" ")){
                if(!frequencies.containsKey(s)) frequencies.put(s, 1);
                else frequencies.put(s, frequencies.get(s) + 1);
            }
            
            List<String> ansList = new ArrayList<>();
            for(String key: frequencies.keySet()){
                if(frequencies.get(key) == 1) ansList.add(key);
            }
            
            String[] ans = new String[ansList.size()];
            for(int i = 0; i < ansList.size(); i++) {
                ans[i] = ansList.get(i);
            }
            
            return ans;
        }
    }
}
