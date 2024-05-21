class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++){
            int currCount = ans.size();
            while(currCount > 0){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(ans.get(currCount - 1));
                temp.add(nums[i]);
                ans.add(temp);
                currCount--;
            }
            
        }
        
        return ans;
    }
}