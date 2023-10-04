class Solution {
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        boolean[] cycle = new boolean[n];
        
        for(int i = 0 ; i < n; i++){
            hm.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges){
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }
        
        
        if(isCyclic(0, -1, cycle, visited)) return false;
        
        for(int i = 0 ; i < n; i++){
            if(visited[i] != true) return false;
        }
        
    
        
        return true;
    }
    
    private boolean isCyclic(int idx, int prevIdx, boolean[] cycle, boolean[] visited){
        List<Integer> neighbours = hm.get(idx);
        if(neighbours.size() == 0){
            visited[idx] = true;
            return false;
        }
        
        if(cycle[idx] == true) {
            visited[idx] = true;
            return true;
        }
        
        boolean check = false;
        cycle[idx] = true;
        for(Integer i : neighbours){
            if(i == prevIdx) continue;
            if(check) break;
            if(isCyclic(i, idx, cycle, visited)) {
                check = true;
            }
        }
        cycle[idx] = false;
        
        visited[idx] = true;
        return check;
    }
}