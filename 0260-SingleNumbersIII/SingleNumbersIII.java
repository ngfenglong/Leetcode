
class SingleNumbersIII {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int bitmask = 0;
            for(int i: nums){
                bitmask ^= i;
            }
            
            int diff = bitmask & (-bitmask);
            
            int x = 0;
            for (int i : nums){
                if((i & diff) != 0) x ^= i;
            }
            
            return new int[]{x, bitmask ^ x};
        }
    }
}
