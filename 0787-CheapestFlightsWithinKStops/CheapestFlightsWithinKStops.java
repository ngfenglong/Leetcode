import java.util.*;

class CheapestFlightsWithinKStops {
    
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            if(src == dst) return 0;
            HashMap<Integer, List<Flight>> graph = new HashMap<>();
            
            for(int i = 0; i < flights.length; i++){
                graph.putIfAbsent(flights[i][0], new ArrayList<>());
                graph.get(flights[i][0]).add(new Flight(flights[i][1],flights[i][2]));
            }
            
            // [dst, totalCost, k]
            PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
            
            // Starting point is src
            if(!graph.containsKey(src)) return -1;
            
            queue.add(new int[]{src, 0, 0});
    
            int[] stops = new int[n];
            Arrays.fill(stops, Integer.MAX_VALUE);
            
            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                int currDst = curr[0];
                int currTotalCost = curr[1];
                int currK = curr[2];
                
                if(currDst == dst) return currTotalCost;
                
                if(currK > stops[currDst] || currK >= k + 1) continue;
                
                stops[currDst] = currK;
                
                if(!graph.containsKey(currDst)) continue;
                
                for(Flight f: graph.get(currDst)) {
                    queue.add(new int[]{f.dst, f.cost + currTotalCost, currK + 1});
                }  
            }
            
            return -1;
        }
        
        
        class Flight {
            int cost;
            int dst;
            
            public Flight(int dst, int cost){
                this.dst = dst;
                this.cost = cost;
            }
            
        }
    }
}
