import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        String[] ans = new String[score.length];
        for(int i = 0; i < score.length; i++){
            hm.put(score[i], i);
        }
        
        Arrays.sort(score);
        for(int i = 0; i < score.length; i++){
            int idx = hm.get(score[i]);
            String pos = "";
            if(i == score.length - 1){
                pos = "Gold Medal";
            }
            else if(i == score.length - 2){
                pos = "Silver Medal";
            }
            else if(i == score.length - 3){
                pos = "Bronze Medal";
            }
            else{
                pos = (score.length - i) + "";    
            }
            ans[idx] = pos;
        }
        
        return ans;
    }
}