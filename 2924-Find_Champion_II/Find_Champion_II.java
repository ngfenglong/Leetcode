class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] losses = new int[n];
        
        for(int i = 0; i < edges.length; i++){
            losses[edges[i][1]]++;
        }
        
        
        int champion = -1;
        for(int i = 0 ; i < losses.length; i++){
            if(losses[i] == 0){
                if(champion != -1) return -1;
                champion = i;
            }
        }
        
        return champion;
    }
}