import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        // O(n log n)
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });
        
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i = 1 ; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        list.add(new int[]{start, end});
        
        
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        
        return ans;
    }
}