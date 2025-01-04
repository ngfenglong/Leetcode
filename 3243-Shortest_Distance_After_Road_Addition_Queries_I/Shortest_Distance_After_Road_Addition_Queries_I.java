import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] dp = new int[n];
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        hm.put(n - 1, new ArrayList<>());        
        for(int i = n - 2; i >= 0; i--){
            dp[i] = dp[i + 1] + 1;
            hm.put(i, new ArrayList<>());
            hm.get(i).add(i + 1);
        }
        
        for(int i = 0; i < queries.length; i++){
            int from = queries[i][0];
            int to = queries[i][1];
            
            hm.get(from).add(to);
            
            for(int j = from; j >= 0; j--){
                for(Integer p: hm.get(j)){
                    dp[j] = Math.min(dp[j], dp[p] + 1);
                }
            }
            
            ans[i] = dp[0];
        }
        
        return ans;
    }
}
