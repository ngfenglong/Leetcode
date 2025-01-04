import java.util.*;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int cumm = 0; 
        for(int i = 0; i < arr.length; i++){
            cumm = cumm ^ arr[i];
            hm.put(i, cumm);
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            
            if(left == 0) ans[i] = hm.get(right);
            else ans[i] = hm.get(left - 1) ^ hm.get(right);
        }
        
        return ans;
    }
}