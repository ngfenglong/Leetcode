import java.util.*;

public class BrickWall {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer, Integer> linesHM = new HashMap<>();
    
            //NM
            for(int i = 0; i < wall.size(); i++){
                int col = 0;
                for(int j = 0; j < wall.get(i).size() - 1; j++){
                    col += wall.get(i).get(j);
                    linesHM.put(col, linesHM.getOrDefault(col, 0) + 1);
                }
            }
    
            int maxLines = 0;
            for(Integer col: linesHM.keySet()){
                maxLines = Math.max(maxLines, linesHM.get(col));
            }
    
    
            return wall.size() - maxLines;
        }
    }
}