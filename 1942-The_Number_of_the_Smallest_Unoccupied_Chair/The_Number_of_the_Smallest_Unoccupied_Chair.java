class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] starts = new int[times.length][2];
        int[][] ends = new int[times.length][2];
        
        splitTime(times, starts, ends);
        sortTime(starts);
        sortTime(ends);
        
        
        PriorityQueue<Integer> seatsAvailable = new PriorityQueue<>();
        int[] seats = new int[times.length];
        int maxSeat = 0;
        int endPointer = 0;
        
        for(int i = 0; i < starts.length; i++){
            int startIdx = starts[i][1];
            while(endPointer < i && ends[endPointer][0] <= starts[i][0]){
                int endIdx = ends[endPointer][1];
                seatsAvailable.add(seats[endIdx]);
                endPointer++;
            }
            
            int selectedSeat = -1;
            if(!seatsAvailable.isEmpty()){
                selectedSeat = seatsAvailable.poll();
            }
            else {
                selectedSeat = maxSeat;
                maxSeat++;
            }
            
            seats[startIdx] = selectedSeat;
            if(startIdx == targetFriend) return selectedSeat;
        }
        
        return maxSeat;
    }
    
    private void splitTime(int[][] times, int[][] starts, int[][] ends){
        for(int i = 0; i < times.length; i++) {
            starts[i][0] = times[i][0];
            ends[i][0] = times[i][1];
            starts[i][1] = i;
            ends[i][1] = i;
        }
    }
    
    private void sortTime(int[][] arr){
          Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] i1, int[]i2){
                if(i1[0] == i2[0]){
                    return Integer.compare(i1[1], i2[1]);    
                }
                return Integer.compare(i1[0], i2[0]);
            }
        });
    }
}