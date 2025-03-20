import java.util.*;

public class MinimumCostWalkWeightedGraph {
    class Solution {
        HashMap<Integer, Integer> groupCost = new HashMap<>();
        HashMap<Integer, Set<Integer>> groupEdges = new HashMap<>(); 
        HashMap<Integer, Set<Integer>> groupMembers = new HashMap<>();
    
        private int getSmallestCost(int group){
           Set<Integer> set = groupEdges.get(group);
           if(set.size() == 0) return -1;
    
           List<Integer> edges = new ArrayList<>(set);
           int cost = edges.get(0);
    
           for(int i = 1; i < edges.size(); i++){
                cost &= edges.get(i);
           }
    
           return cost;
        }
    
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
                int[] groups = new int[n];
    
                for(int i = 0; i < n; i++){
                    groupEdges.put(i, new HashSet<>());
                    
                    groups[i] = i;
                    groupMembers.put(i, new HashSet<>());
                    groupMembers.get(i).add(i);
                }
    
                for(int i = 0; i < edges.length; i++){
                    int a = edges[i][0];
                    int b = edges[i][1];
                    int w = edges[i][2];
    
                    int newParent = Math.min(groups[a], groups[b]);
                    int oldParent = Math.max(groups[a], groups[b]);
    
                    if(newParent != oldParent){
                        for(int member: groupMembers.get(oldParent)){
                            groups[member] = newParent;                        
                        }
    
                        groupEdges.get(newParent).addAll(groupEdges.get(oldParent));
                        groupMembers.get(newParent).addAll(groupMembers.get(oldParent));
                        groupMembers.remove(oldParent);
                        groupEdges.remove(oldParent);
                    }
    
                    groupEdges.get(newParent).add(w);
                }
    
    
                for(int key: groupEdges.keySet()){
                    groupCost.put(key, getSmallestCost(key));
                }
    
                int[] ans = new int[query.length];
                Arrays.fill(ans, -1);
                for(int i = 0 ; i < query.length; i++){
                    int a = query[i][0];
                    int b = query[i][1];
                    if(groups[a] == groups[b]){
                        ans[i] = groupCost.get(groups[a]);
                    }
                }
    
                return ans;
        }
    }
    
}