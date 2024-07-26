class Solution {
    Map<Integer, Map<Integer, Integer>> vectors = new HashMap<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        populateVectors(edges);
        
        int[] numberOfCities = new int[n];
        for(int i = 0; i < n; i++){
            numberOfCities[i] = calculateCitiesTravelled(i, distanceThreshold, n);            
        }
        
        
        int city = -1;
        int leastCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(numberOfCities[i] <= leastCount){
                city = i;
                leastCount = numberOfCities[i];
            }
        }
     
        return city;
    }
    
    private void populateVectors(int[][] edges) {
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int distance = edges[i][2];
            
            if(!vectors.containsKey(a))vectors.put(a, new HashMap<>());
            if(!vectors.containsKey(b))vectors.put(b, new HashMap<>());
            
            vectors.get(a).put(b, distance);
            vectors.get(b).put(a, distance);
        }
        
    }
    
    private int calculateCitiesTravelled(int start, int threshold, int n){
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return Integer.compare(arr1[1], arr2[1]);
            }
        });
        
        queue.offer(new int[]{start, 0});

        int count = -1;
        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            int curr = temp[0];
            int dist = temp[1];
         
            if(!visited[curr] && dist <= threshold){
                count++;
                visited[curr] = true;
                if(vectors.containsKey(curr)){
                    for(int next : vectors.get(curr).keySet()){
                        if(!visited[next]) {
                            int newDist = dist + vectors.get(curr).get(next);
                            if(newDist <= threshold) queue.offer(new int[]{next, newDist}); 
                        }
                    }    
                }
            }
        }
        return count;
    }
}