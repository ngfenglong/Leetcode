import java.util.*;

class Combinations {
    class Solution {
        int n;
        int k;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            this.n = n;
            
            recursion(new ArrayList<>(), 1);
            return results;
            
        }
        
        private void recursion(List<Integer> list, int idx){
            if(list.size() == k){
                results.add(new ArrayList<>(list));            
                return;
            }
            
            if(idx > n) return;
            
            // Not take
            recursion(list, idx + 1);
            
            // Take 
            list.add(idx);
            recursion(list, idx + 1);
            list.remove(list.size() - 1);        
        }    
    }
}
