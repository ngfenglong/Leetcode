class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int r = rStart;
        int c = cStart;
        
        int[][] ans = new int[n][2];
        int idx = 0;
        
        int direction = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        int space = 1;
        int steps = space;
        
        while(idx < n){
            if(r >= 0 && r < rows && c >= 0 && c < cols){
                ans[idx++] = new int[]{r, c};
            }    
               
           if(steps == 0){
                if(direction % 2 == 1) space++;
                direction = (++direction) % 4;
                steps = space;
            }
            
            
            if(direction == 0){
                c++;
            }
            else if(direction == 1) {
               r++;
            }
            else if (direction == 2){
                c--;
            }
            else {
                r--;
            }
            
            steps--;
        }

        return ans;
    }
}