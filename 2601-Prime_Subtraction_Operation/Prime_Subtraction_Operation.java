import java.util.*;


class Solution {
    public boolean primeSubOperation(int[] nums) {                
        int maxNum = getMaxNum(nums);        
        boolean[] isPrimeArr = new boolean[maxNum + 1];
        
        generatePrimeNumberList(isPrimeArr);
        
        int i = 0;
        int curr = 1;
        
        while(i < nums.length){
            int difference = nums[i] - curr;
            
            // Not possible anymore
            if(difference < 0) return false;
            
            // Set the curr index with the currnum (lowest possible number for this slot)
            if(difference == 0 || isPrimeArr[difference]){
                i++;
                curr++;
            }
            else {
                curr++;
            }
        }
        
        return true;
    }
    
    //Sieve of Eratosthenes
    private void generatePrimeNumberList(boolean[] isPrimeArr){        
        Arrays.fill(isPrimeArr, true);
        
        isPrimeArr[0] = false;
        isPrimeArr[1] = false;
        
        for(int i = 2; i < isPrimeArr.length; i++){
            if(isPrimeArr[i]){
                for(int j = i * i; j < isPrimeArr.length; j += i){
                    isPrimeArr[j] = false;
                }
            }
        }
    }
    
    
    private int getMaxNum(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int num: nums){
            max = Math.max(max, num);
        }
        
        return max;
    }
}


