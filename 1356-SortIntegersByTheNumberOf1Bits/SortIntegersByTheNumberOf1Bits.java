import java.util.*;

class SortIntegersByTheNumberOf1Bits {
    
    
    class Solution {
        public int[] sortByBits(int[] arr) {
            Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    if (Integer.bitCount(i1) == Integer.bitCount(i2)) {
                        return i1 - i2;
                    }
            
                    return Integer.bitCount(i1) - Integer.bitCount(i2);
                }
            });
        
            return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        }
      
    }
}
