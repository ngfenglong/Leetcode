import java.util.*;

class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            HashMap<Integer, List<Integer>> hm = new HashMap<>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            
            // O(n)        
            for(int i = 0; i < groupSizes.length; i++){
                int size = groupSizes[i];
                if(!hm.containsKey(size)) hm.put(size, new ArrayList<>());
                hm.get(size).add(i);
                
                if(hm.get(size).size() == size){
                    ans.add(hm.get(size));
                    hm.put(size, new ArrayList<>());
                }
            }
            
            return ans;
        }
    }
}
