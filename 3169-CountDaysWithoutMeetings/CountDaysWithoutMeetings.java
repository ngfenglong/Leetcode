import java.util.*;

public class CountDaysWithoutMeetings {
    class Solution {
        public int countDays(int days, int[][] meetings) {
            Arrays.sort(meetings, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    if(a[0] == b[0]){
                        return Integer.compare(a[1], b[1]);
                    }
                    return Integer.compare(a[0], b[0]);
                }
            });
    
            List<int[]> sortedMeetings = new ArrayList<>();
            for(int i = 0; i < meetings.length; i++){
                int from = meetings[i][0];
                int to = meetings[i][1];
    
                int mSize = sortedMeetings.size();
                if(mSize == 0 || from > sortedMeetings.get(mSize - 1)[1]){
                    sortedMeetings.add(new int[]{from, to});
                }
                else {
                    int[] prevTiming = sortedMeetings.get(mSize - 1);
                    prevTiming[1] = Math.max(prevTiming[1], to);
                }
            }
            sortedMeetings.add(new int[]{days + 1, days+2});
    
            int daysWithoutMeeting = 0;
            int curr = 1;
            for(int[] timing: sortedMeetings){
                daysWithoutMeeting += timing[0] - curr;
                curr = timing[1] + 1;
            }
    
            return daysWithoutMeeting;
        }
        
    }
}