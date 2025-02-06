import java.util.*;

public class TupleWithSameProduct {
    class Solution {
        public int tupleSameProduct(int[] nums) {
            // Pair * numOfOtherPair * 2 (the first pair can swap) * 2(other pair can swap within the number) * 2(order can swap)
            // = (N - 1)! * 2 * 2 * 2
    
            // Sum up all the pairs from each sum
    
            HashMap<Integer, Integer> sumCombi = new HashMap<>();
            for(int i = 0 ; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    int product = nums[i] * nums[j];
                    sumCombi.put(product, sumCombi.getOrDefault(product, 0) + 1);
                }
            }
    
            int ans = 0;
            for(Integer key: sumCombi.keySet()){
                int numOfCombi = sumCombi.get(key);
           
                int localSum = (numOfCombi * (numOfCombi - 1))/2; // to avoid multi calculate for switch place
                ans += (localSum * 8);         
            }
    
            return ans;
        }
    }
    
}