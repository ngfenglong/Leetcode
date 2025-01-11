import java.util.*;

class MinimumHeightTrees {
    
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if(n == 1) {
                List<Integer> ans = new ArrayList<>();
                ans.add(0);
                return ans;
            }
            
            List<Set<Integer>> neighbours = new ArrayList<>();
            for(int i = 0; i < n; i++){
                neighbours.add(new HashSet<>());
            }
            for(int[] edge: edges){
                neighbours.get(edge[0]).add(edge[1]);
                neighbours.get(edge[1]).add(edge[0]);
            }
            
            List<Integer> leaves = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(neighbours.get(i).size() == 1){
                    leaves.add(i);
                }
            }
            
            // try to get center node 
            int remainingNodes  = n;
            while(remainingNodes > 2){
                remainingNodes -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();
                for(Integer leave: leaves){
                    for(Integer neighbour: neighbours.get(leave)){
                        neighbours.get(neighbour).remove(leave);
                        if(neighbours.get(neighbour).size() == 1) newLeaves.add(neighbour);
                    } 
                }
                
                leaves = newLeaves;
            }
            
            return leaves;
        }
    }
}
