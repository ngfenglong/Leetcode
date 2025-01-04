import java.util.*;
class Solution {
    
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> lostHM = new HashMap<>();
        
        for(int i = 0; i < matches.length; i++){
            int winner = matches[i][0];
            int loser = matches[i][1];
            lostHM.put(loser, lostHM.getOrDefault(loser, 0) + 1);
            lostHM.put(winner, lostHM.getOrDefault(winner, 0));
        } 
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        for(Integer i : lostHM.keySet()){
            if(lostHM.get(i) == 0) ans.get(0).add(i);
            if(lostHM.get(i) == 1) ans.get(1).add(i);
        }
        
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
    
        return ans;
    }
}