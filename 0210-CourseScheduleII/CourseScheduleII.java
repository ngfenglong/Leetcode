import java.util.*;

class CourseScheduleII {
    
    
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Reverse the graph -----   Prerequiste -> Module
            
            // Keep a indegree to check how many more prerequisites required in order to take the module
            
            // Keep a queue to store the next cleared pre-requisite module. 
            
            // Add the modules order in a list -> To check size (if it is possible)
            
            
            
            List<List<Integer>> vectors = new ArrayList<List<Integer>>();
            int[] inDegrees = new int[numCourses];
            
            for(int i = 0; i < numCourses; i++) {
                vectors.add(new ArrayList<>());
            }
            
            for(int i = 0; i < prerequisites.length; i++){
                int mod = prerequisites[i][0];
                int preReq = prerequisites[i][1];
                
                inDegrees[mod]++;
                vectors.get(preReq).add(mod);
            }
            
            
            List<Integer> order = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            
            for(int i = 0; i < numCourses; i++){
                if(inDegrees[i] == 0) queue.add(i);
            }
            
            while(!queue.isEmpty()){
                int mod = queue.poll();
                order.add(mod);
                
                for(Integer i : vectors.get(mod)){
                    inDegrees[i]--;
                    if(inDegrees[i] == 0) queue.add(i);
                }
            }
            
            if(order.size() == numCourses) {
                int[] ans = new int[numCourses];
                for(int i = 0; i < numCourses; i++){
                    ans[i] = order.get(i);
                }    
                return ans;
            }
            
            return new int[]{};
        }
    }
}
