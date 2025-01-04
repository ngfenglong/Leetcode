import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < order.length(); i++){
            hm.put(order.charAt(i), i);
        }
        
        int[] freq = new int[26];
        Set<Character> wildCharacters = new HashSet<>();
        for(char c: s.toCharArray()){
            if(!hm.containsKey(c)) wildCharacters.add(c);
             freq[c-'a']++;
        }
        
        List<Character> keys = new ArrayList(hm.keySet());
        Collections.sort(keys, (c1, c2) -> hm.get(c1) - hm.get(c2));
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keys.size(); i++){
            char c = keys.get(i);
            while(freq[c - 'a'] > 0){
                sb.append(c);
                freq[c - 'a']--;
            }
        }
        
        for(Character c : wildCharacters){
            while(freq[c - 'a'] > 0){
                sb.append(c);
                freq[c - 'a']--;
            }
        }
        
        return sb.toString();
    }
}