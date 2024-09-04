class Solution {    
    public int robotSim(int[] commands, int[][] obstacles) {
        // 0 - north, 1 - east, 2 - south, 3 - west
        int[][] PATHS = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        HashMap<Integer, Set<Integer>> obstacleHM = new HashMap<>();
        
        int maxDistance = 0;
        int direction = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < obstacles.length; i++) {
            obstacleHM.putIfAbsent(obstacles[i][0], new HashSet<>());
            obstacleHM.get(obstacles[i][0]).add(obstacles[i][1]);
        }
        
        
        for(int command : commands){
            if(command == -1) direction = (direction + 1) % 4;
            else if(command == -2) direction = (direction + 4 - 1) % 4;
            
            else {
                int[] path = PATHS[direction];
                for(int j = 0; j < command; j++){
                    x += path[0];
                    y += path[1];
                    
                    if(obstacleHM.containsKey(x) && obstacleHM.get(x).contains(y)){
                        x -= path[0];
                        y -= path[1];
                        break;
                    }
                }
                maxDistance = Math.max(maxDistance, getDistance(x,y));
            }
        }
        
        return maxDistance;
    }
    
    
    private int getDistance(int x, int y){
        return (x * x) + (y * y);
    } 
}