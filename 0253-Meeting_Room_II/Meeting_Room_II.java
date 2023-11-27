class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime  = new int[intervals.length];
        int[] endTime  = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        // 0, 5, 15
        // 10, 20, 30
        
        int count = 1;
        int endCounter = 0;
        for(int startCounter = 1; startCounter < startTime.length; startCounter++){
            if(startTime[startCounter] < endTime[endCounter]){
                count++;
            }
            else{
                endCounter++;
            }
        }
        
        return count;
        
    }
}