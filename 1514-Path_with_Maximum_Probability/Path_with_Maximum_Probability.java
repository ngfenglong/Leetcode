class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < edges.length; i++){
            int nodeA = edges[i][0];
            int nodeB = edges[i][1];
            
            graph.putIfAbsent(nodeA, new ArrayList<>());
            graph.putIfAbsent(nodeB, new ArrayList<>());
            
            graph.get(nodeA).add(new double[]{nodeB, succProb[i]});
            graph.get(nodeB).add(new double[]{nodeA, succProb[i]});
        }
        
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        
        if (!graph.containsKey(start_node)) return 0;
        
        for (double[] neighbor : graph.get(start_node)) {
            queue.add(new double[]{neighbor[0], neighbor[1]});
        }
        
        while(!queue.isEmpty()) {
            double[] current = queue.poll();
            int currentNode = (int) current[0];
            double currentProb = current[1];
            
            if (currentNode == end_node) return currentProb;            
            if (visited[currentNode]) continue;            
            
            visited[currentNode] = true;
            
            for (double[] neighbor : graph.get(currentNode)) {
                queue.add(new double[]{neighbor[0], neighbor[1] * currentProb});
            }
        }
        
        return 0;
    }
}