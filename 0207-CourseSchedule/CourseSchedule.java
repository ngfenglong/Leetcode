import java.util.*;

class CourseSchedule {
    
    class Solution {
        HashMap<Integer, List<Integer>> vertices = new HashMap<>();
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for(int i = 0; i < numCourses; i++){
                vertices.put(i, new ArrayList<>());
            }
            
            for(int i = 0; i < prerequisites.length; i++){
                vertices.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
    
            boolean[] visited = new boolean[numCourses];
            boolean[] inStack = new boolean[numCourses];
    
            for(int i = 0; i < numCourses; i++){
                if(!visited[i]){
                    if(isCyclic(i, visited, inStack)) return false;
                }
            }
            
            return true;
        }
        
        
        private boolean isCyclic(int idx, boolean[] visited, boolean[] inStack){
            List<Integer> prerequisite = vertices.get(idx);
            if(prerequisite.size() == 0){
                visited[idx] = true;
                return false;
            }
            
            if(visited[idx]) return false;
            if(inStack[idx]){
                visited[idx] = true;
                return true;
            }
            
            boolean check = false;
            inStack[idx] = true;
            for(Integer p: prerequisite){
                if(check) break;
                
                check = isCyclic(p, visited, inStack);
            }
            
            inStack[idx] = false;
            visited[idx] = true;
            return check;
        }
        
    }
}
