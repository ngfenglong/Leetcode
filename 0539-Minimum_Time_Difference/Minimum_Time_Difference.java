import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<int[]> times = new ArrayList<int[]>();
        
        for(String s: timePoints){
            String[] timeParts = s.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            
            times.add(new int[]{hours, minutes});
        }
        
        
        Collections.sort(times, new Comparator<int[]>() {
            public int compare(int[] time1, int[] time2) {
                if (time1[0] == time2[0]) {
                    return Integer.compare(time1[1], time2[1]);
                }
                return Integer.compare(time1[0], time2[0]);
            }
        });
                
        int minDiff = Integer.MAX_VALUE;
        
        int[] lastTime = times.get(times.size() - 1);
        int lastHour = lastTime[0] - 24;  
        int lastMinute = lastTime[1];
        
        
        for(int[] currTime: times){
            int currHour = currTime[0];
            int currMinute = currTime[1];
            
            int diff = 0;
            if(currMinute < lastMinute) {
                diff = ((currHour - 1 - lastHour) * 60) + (currMinute + 60 - lastMinute);
            }
            else{
                diff = ((currHour - lastHour) * 60) + (currMinute - lastMinute);
            }
            
            if(diff == 0) return 0;
            
            minDiff = Math.min(diff, minDiff);
            
            lastHour = currHour;
            lastMinute = currMinute;
        }
        
        return minDiff;
    }
}