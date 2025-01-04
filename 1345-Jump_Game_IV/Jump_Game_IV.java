import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        // Shortest  distance -> BFS 
        
        // Keep track of the "teleport" --> store it in a HashMap<Integer, List<Index>>
        
        // start from the first step --> Queue 
        // Keep track of the count
            // For each iteratin, we will check the possible location to go to -> i + 1, i - 1, teleport
            // store a visited[] -> If already visited, we will skip 
            // if w reach n - 1 --> return count; 
        
        
        boolean[] visited = new boolean[arr.length];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!graph.containsKey(arr[i])) {
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            while(n > 0){
                int idx = queue.poll();
                
                if(idx == arr.length - 1) return count;
                
                List<Integer> teleports = graph.get(arr[idx]);
                for(Integer t: teleports) {
                    if(!visited[t]) {
                        visited[t] = true;
                        queue.add(t);
                    }
                }
                graph.get(arr[idx]).clear();
                
                if(idx > 0) {
                    if(!visited[idx - 1]){
                        visited[idx - 1] = true;
                        queue.add(idx - 1);
                    }
                }
                
                if(!visited[idx + 1]){
                        visited[idx + 1] = true;
                        queue.add(idx + 1);
                }
                n--;
            }
            count++;
        }
        
        return -1;
    }
}