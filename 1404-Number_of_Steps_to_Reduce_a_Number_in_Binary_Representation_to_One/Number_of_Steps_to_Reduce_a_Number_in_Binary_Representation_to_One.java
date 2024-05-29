class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int i = s.length() - 1;
        int totalOperations = 0;
        
        while(i > 0){
            int curr = s.charAt(i) - '0';
            curr = curr + carry;
            
            if(curr == 1) totalOperations++;
            
            if(curr > 0) carry = 1;        
            else carry = 0;
            
            totalOperations++;
            i--;
        }
        
        if(carry == 1) totalOperations++;
        
        return totalOperations;
    }
}