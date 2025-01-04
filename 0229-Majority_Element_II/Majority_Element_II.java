import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyer-Moore Majority Vote Algo
        // There can only be at most 2 elements with a frequency > n/3, so we only have to keep track of the top 2 number
        int firstCount = 0;
        int secondCount = 0; 
        
        Integer firstNum = null;
        Integer secondNum = null;
        
        // Traverse the array to look for the top 2 number
        for(int num : nums){
            if(firstNum != null && firstNum == num){
                firstCount++;
            } else if(secondNum != null && secondNum == num){
                secondCount++;
            } else if (firstCount == 0) {
                firstNum = num;
                firstCount = 1;
            } else if (firstCount == 0) {
                firstNum = num;
                firstCount = 1;
            } else if (secondCount == 0) {
                secondNum = num;
                secondCount = 1;
            } else {
                firstCount--;
                secondCount--;                
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        // Check if first num & second num has a frequency that is > n/3 
        firstCount = 0;
        secondCount = 0;
        int target = nums.length / 3;
        
        for(int num : nums){
            if(firstNum != null && num == firstNum) firstCount++;
            if(secondNum != null && num == secondNum) secondCount++;
        }
        
        if(firstCount > target) ans.add(firstNum);
        if(secondCount > target) ans.add(secondNum);
        
        return ans;
    }
}
