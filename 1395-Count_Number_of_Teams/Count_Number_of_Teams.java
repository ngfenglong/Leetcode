import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        HashMap<Integer, List<Integer>> increasingHM = new HashMap<>();
        HashMap<Integer, List<Integer>> decreasingHM = new HashMap<>();
        
        for(int i = 0; i < rating.length; i++){
            increasingHM.put(i, new ArrayList<>());
            decreasingHM.put(i, new ArrayList<>());
            
            for(int j = i + 1; j < rating.length; j++){
                if(rating[j] > rating[i]) increasingHM.get(i).add(j);
                if(rating[j] < rating[i]) decreasingHM.get(i).add(j);
            }
        }
        
        int ans = 0;
        for(int i = 0; i < rating.length; i++){
            for(Integer j: increasingHM.get(i)){
                ans += increasingHM.get(j).size();
            }
            
            for(Integer j: decreasingHM.get(i)){
                ans += decreasingHM.get(j).size();
            }
        }
        
        return ans;
    }
}