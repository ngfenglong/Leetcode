import java.util.*;

class CountTheNumberHousesAtACertainDistanceI {
    
    class Solution {
        public int[] countOfPairs(int n, int x, int y) {
            
            List<List<Integer>> vectors = new ArrayList<List<Integer>>();
            
            vectors.add(new ArrayList<>());
            for(int i = 1; i < n; i++){
                vectors.add(new ArrayList<>());
                vectors.get(i - 1).add(i);
                vectors.get(i).add(i-1);
            }
            
            vectors.get(x-1).add(y-1);
            vectors.get(y-1).add(x-1);
            
            int[] ans = new int[n];
            for(int i = 0; i < n; i++){
                boolean[] visited = new boolean[n];
                visited[i] = true;
                
                Queue<Integer> queue = new LinkedList<>();
                for(int neighbour: vectors.get(i)){
                    queue.add(neighbour);
                }
                
                int distance = -1;
                while(!queue.isEmpty()){
                    distance++;
                    int size = queue.size();
                    for(int j = 0; j < size; j++){
                        int curr = queue.poll();
                        if(!visited[curr]){
                            visited[curr] = true;
                            ans[distance]++;
                            for(int neighbour: vectors.get(curr)){
                                if(!visited[neighbour]) queue.add(neighbour);
                            }
                        }
                    }
                }
                
            }
            return ans;
        }
    }
}
