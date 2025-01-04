import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        Map<Integer,Integer> tm = new TreeMap<Integer, Integer>();
        
        for(int i = 0; i < hand.length; i++){
            tm.put(hand[i], tm.getOrDefault(hand[i], 0) + 1);
        }
        
        while(tm.size() != 0){
            int start = tm.entrySet().iterator().next().getKey();
            
            for(int i = 0 ; i < groupSize; i++){
                if(!tm.containsKey(start + i)) return false;
                
                int currVal = tm.get(start + i);
                if(currVal == 1) tm.remove(start + i);
                else tm.put(start + i, currVal - 1);
            }
        }
        
        return true;
        
    }
}