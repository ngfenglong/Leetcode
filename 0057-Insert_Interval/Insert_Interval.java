class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<int[]>();
        boolean addedNew = false;
        for(int i = 0; i < intervals.length; i++){
            if(!addedNew && intervals[i][0] >= newInterval[0]){
                if(intervals[i][0] > newInterval[0] || (intervals[i][0] == newInterval[0] && intervals[i][1] > newInterval[1])){
                    list.add(newInterval);
                    list.add(intervals[i]);
                }
                else {
                    list.add(intervals[i]);
                    list.add(newInterval);
                }
                addedNew = true;
            }
            else {
                list.add(intervals[i]);
            }
        }
        // If not added, add to the end
        if(list.size() == intervals.length){
            list.add(newInterval);
        }
        
        
        List<int[]> ans = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        
        for(int i = 1; i < list.size(); i++){
            if(list.get(i)[0] <= end){
                end = Math.max(end, list.get(i)[1]);    
            }
            else {
                ans.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        
        ans.add(new int[]{start, end});
        
        return ans.toArray(new int[ans.size()][2]);
    }
}