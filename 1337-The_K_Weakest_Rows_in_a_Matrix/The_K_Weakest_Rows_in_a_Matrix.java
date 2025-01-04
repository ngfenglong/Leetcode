import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int i = 0 ; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 1) break;
                count++;
            }
            if(!hm.containsKey(count)) hm.put(count, new ArrayList<>());
            hm.get(count).add(i);
        }
            
            
        List<Integer> keys = new ArrayList<>(hm.keySet());
        Collections.sort(keys);
        
        int[] ans = new int[k];
        int i = 0;
        for(Integer key: keys){
            for(Integer idx : hm.get(key)){
                if(i == k) return ans;
                ans[i++] = idx;
            }
        }
        
        return ans;
    }
}