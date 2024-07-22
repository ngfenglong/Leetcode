class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> hm = new HashMap<>();
        int n = heights.length;
        
        for(int i = 0; i < n; i++){
            hm.put(heights[i], names[i]);
        }
            
        Arrays.sort(heights);
        
        String[] ans = new String[n];
        for(int i = 0 ; i< n; i++){
            ans[n - i - 1] = hm.get(heights[i]);
        }
        
        return ans;
    }
}