class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int startPointer = 0;
        int i = 0;
        int max = 0;
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, i);
            }   
            else{
                int idx = hm.get(c);
                if(idx >= startPointer){
                    max = Math.max(max, i - startPointer);
                    startPointer = idx + 1;
                }
                hm.put(c, i);
            }
            
            i++;
        }
        
        max = Math.max(max, i - startPointer);
        return max;
    }
}