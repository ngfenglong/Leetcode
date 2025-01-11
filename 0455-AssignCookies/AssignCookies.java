import java.util.*;

class AssignCookies {
    
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            
            int j = 0;
    
            for(int i = 0; i < g.length; i++){
                while(j < s.length && s[j] < g[i]){
                    j++;
                }
                if(j >= s.length) return i;
                j++;
            }
            
            return g.length;
                
        }
    }
}
