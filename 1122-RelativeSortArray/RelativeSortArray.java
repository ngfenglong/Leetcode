import java.util.*;

class RelativeSortArray {
    
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            List<Integer> remainingElements = new ArrayList<>(); 
                    
            for(int i = 0 ; i < arr2.length; i++){
                set.add(arr2[i]);            
            }
            
            int[] ans = new int[arr1.length];
            int p = arr1.length - 1;
            
            for(int i = 0; i < arr1.length; i++){
                hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
                
                if(!set.contains(arr1[i])){
                    remainingElements.add(arr1[i]);
                }
            }
            
            Collections.sort(remainingElements);
            
            p = 0;
            for(int i = 0; i < arr2.length; i++){
                int freq = hm.get(arr2[i]);
                while(freq > 0){
                    ans[p++] = arr2[i];
                    freq--;
                }
            }
            for(Integer i : remainingElements){
                ans[p++] = i;
            }
            
            return ans;
        }
    }
}
