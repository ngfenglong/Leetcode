import java.util.*;

class SortTheJumbledNumbers {
    
    class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            
            int[] ans = new int[nums.length];
            Integer[] tempArr = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++){
                int hashed = getHashedValue(nums[i], mapping);
                hm.put(nums[i], hashed);
                tempArr[i] = nums[i];
            }
            
            Arrays.sort(tempArr, new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                    return Integer.compare(hm.get(i1), hm.get(i2));
                }
            });
            
            for(int i = 0; i < ans.length; i++){
                ans[i] = tempArr[i];
            }
            
            return ans;
        }
        
        private int getHashedValue(int num, int[] mapping){
            int len = ("" + num).length();
            int newNum = 0;
            int pos = 1;
            while(len > 0){
                int val = num % 10;
                int hashed = mapping[val];
                newNum += (hashed * pos);
                
                pos *= 10;
                num /= 10;
                len--;
            }
            
            return newNum;
        }
    }
}
