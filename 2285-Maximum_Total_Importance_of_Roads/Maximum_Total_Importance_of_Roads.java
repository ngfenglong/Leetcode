import java.util.*;
class Solution {
    
    public long maximumImportance(int n, int[][] roads) {
        int[] degrees = new int[n];
        
        for(int i = 0; i < roads.length; i++){
            degrees[roads[i][0]]++;
            degrees[roads[i][1]]++;
        }
        
        Arrays.sort(degrees);
        
        long ans = 0l;
        int impt = 1;
        for(int i = 0; i < degrees.length; i++){
            ans += ((long)impt * degrees[i]);
            impt++;
        }
        
        return ans;
    }
}