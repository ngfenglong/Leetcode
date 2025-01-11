import java.util.*;

class NamingACompany {
    
    class Solution {
        public long distinctNames(String[] ideas) {
            HashMap<Integer, Set<String>> hm = new HashMap<>();
            long count = 0l;
            
            for(int i= 0; i < 26; i++){
                hm.put(i, new HashSet<>());
            }
            
            for(int i = 0; i < ideas.length; i++){
                int c = (int)ideas[i].charAt(0) - 'a';
                String s = ideas[i].substring(1);
                hm.get(c).add(s);
            }
            
            
            for(int i = 0; i < 26; i++){
                Set<String> set = hm.get(i);
                for(int j = i + 1; j < 26; j++){
                    Set<String> set2 = hm.get(j);
                    int duplicate = 0;
                    for(String s: set){
                        if(set2.contains(s)) duplicate++;
                    }
                    count += (long)(2 * (set2.size() - duplicate) * (set.size() - duplicate));
                }
            }
            return count;
        }
    }
}
