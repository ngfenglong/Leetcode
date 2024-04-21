class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] unionFind = new int[n];
        
        for(int i = 0; i < n; i++){
            unionFind[i] = i;
        }
        
        for(int[] edge: edges){
            buildPath(unionFind, edge[0], edge[1]);
        }
        
        return (getParent(unionFind, source) == getParent(unionFind, destination));
    }
    
    private void buildPath(int[] unionFind, int source, int destination){
        int sourceParent = getParent(unionFind,source);
        int destinationParent = getParent(unionFind, destination);
        if(sourceParent < destinationParent) updateParent(unionFind, destination, sourceParent);
        else updateParent(unionFind, source, destinationParent);
    }
    
    // o(lg n) worst n
    private int getParent(int[] unionFind, int source){
        int parent = unionFind[source];
        while(parent != unionFind[parent]){
            parent = unionFind[parent];
        }
        
        return parent;
    }
    
    private void updateParent(int[] unionFind, int source, int newParent) {
        if(unionFind[source] == newParent) return;
        if(unionFind[source] != source) updateParent(unionFind, unionFind[source], newParent);
        unionFind[source] = newParent;
    }
}