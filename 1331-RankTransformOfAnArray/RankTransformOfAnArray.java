import java.util.*;

class RankTransformOfAnArray {
    
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            HashMap<Integer,Integer> sequenceHM = new HashMap<>();
            Set<Integer> set  = new HashSet<>();
            
            for(int i = 0; i < arr.length; i++){
                set.add(arr[i]);
            }
            
            List<Integer> sorted = new ArrayList<>(set);
            Collections.sort(sorted);
            
            int order = 1;
            for(Integer i: sorted){
                sequenceHM.put(i, order);
                order++;
            }
            
            int[] ans = new int[arr.length];
            for(int i = 0; i < arr.length; i++){
                ans[i] = sequenceHM.get(arr[i]);
            }
            
            return ans;
        }
    }
}
