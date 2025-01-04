import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int currHighest = 0;
        
        for(int i = 0; i < s.length(); i++){
            int occur = hm.getOrDefault(s.charAt(i), 0) + 1;
            hm.put(s.charAt(i), occur);
            currHighest = Math.max(currHighest, occur);
        }
        
        int nextHighest = 0;
        Set<Character> keys = hm.keySet();
        StringBuilder sb = new StringBuilder();
        
        while(currHighest > 0){
            nextHighest = 0;
            for(Character c : keys){
                if(hm.get(c) == currHighest) {
                    for(int i = 0; i < currHighest; i++){
                        sb.append(c); 
                    }
                }  
                else if(hm.get(c) < currHighest){
                    nextHighest = Math.max(nextHighest, hm.get(c));
                }
            }
            currHighest = nextHighest;
        }
        
        
        return sb.toString();
    }
}