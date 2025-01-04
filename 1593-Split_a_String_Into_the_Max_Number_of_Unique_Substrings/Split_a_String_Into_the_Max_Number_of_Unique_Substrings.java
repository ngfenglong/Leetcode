import java.util.*;

class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        
        return backTracking(seen, 0, s);
    }
    
    
    private int backTracking(Set<String> seen, int start, String s){
        if(start >= s.length()) return seen.size();
        int result = 0;
        for(int end = start; end < s.length(); end++){
            String substring = s.substring(start, end + 1);
            if(!seen.contains(substring)){
                seen.add(substring);
                result = Math.max(result, backTracking(seen, end + 1, s)); 
                seen.remove(substring);
            }
        }
        return result;
    }
}