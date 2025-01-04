import java.util.*;
class Solution {
    public int pathSum(int[] nums) {
        // Get the depth, create an array based on depth -> 2^depth
        int depth = (nums[nums.length - 1] / 100);
        int[] bst = new int[(int)Math.pow(2, depth)];
        Arrays.fill(bst, -1);
        
        // Fill up the array based on 2 ^ (d - 1) + (P - 1)
        for (int i = 0; i < nums.length; i++){
            int d = nums[i] / 100;
            int p = (nums[i] / 10) % 10;
            int v = nums[i] % 10;
            
            int idx = (int)Math.pow(2, d - 1) + (p - 1);
            bst[idx] = v;
        }
        
        // Sum up using recursive method
        int sum = getSum(bst, 1, 0);
        return sum;
    }
    
    private int getSum(int[] bst, int idx, int sum){
        if(idx >= bst.length || bst[idx] == -1) {
            return sum;
        }
        
        sum += bst[idx];
        boolean hasLeft = idx * 2 < bst.length && bst[idx * 2] > -1;
        boolean hasRight = (idx * 2) + 1 < bst.length && bst[(idx * 2) + 1] > -1;
        if(!hasLeft && !hasRight) return sum;
        if(hasLeft && hasRight) {
            return getSum(bst, idx * 2, sum) + getSum(bst, idx * 2 + 1, sum); 
        }
        
        if(hasLeft) return getSum(bst, idx * 2, sum);
        else return getSum(bst, idx * 2 + 1, sum); 
       
    }
}