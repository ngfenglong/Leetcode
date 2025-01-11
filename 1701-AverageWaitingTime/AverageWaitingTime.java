
class AverageWaitingTime {
    class Solution {
        public double averageWaitingTime(int[][] customers) {
            long currTime = 0l;
            long waitingTime = 0l;
         
            
            for(int i = 0; i < customers.length; i++){
                if(currTime < customers[i][0]) currTime = (long)customers[i][0];
                
                currTime += (long)customers[i][1];
                waitingTime += currTime - customers[i][0];
            }
            
            return (double)waitingTime / customers.length;   
        }
    }
}
