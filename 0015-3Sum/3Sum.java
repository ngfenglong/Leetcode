
class 3Sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // a list to store the answer
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            
            // sort the nums --> O(nlgn)
            Arrays.sort(nums);
            
            int p1 = 0;
            int p2;
            int p3;
            
            while(p1 < nums.length - 2){
                p2 = p1 + 1;
                p3 = nums.length - 1;
                
                while(p2 < p3){
                    int total = nums[p1] + nums[p2] + nums[p3];
                    
                    if(total == 0){
                        ans.add(Arrays.asList(nums[p1],nums[p2],nums[p3]));
                        
                        p2++;
                        while(p2 < p3 && nums[p2] == nums[p2 - 1]) p2++;
                    }
                    else if (total > 0) p3--;
                    else p2++;
                }
                
                // handle p1 + 1 and esure no repeat
                p1++;
                while(p1 < nums.length - 2 && nums[p1] == nums[p1 - 1]) p1++;
                
            }
            
            return ans;
            
        }
    }
}
