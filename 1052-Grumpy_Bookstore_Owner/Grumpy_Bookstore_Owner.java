class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] cummalativesSatisfied = new int[customers.length];
        int[] cummalativeCustomer = new int[customers.length];
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0) {
                sum += customers[i];   
                cummalativesSatisfied[i] += customers[i];
            }
            
            if(i > 0){
                cummalativesSatisfied[i] += cummalativesSatisfied[i - 1];  
                cummalativeCustomer[i] += cummalativeCustomer[i - 1];
            } 
        
            cummalativeCustomer[i] += customers[i];
        }
        
        for(int i = 0; i < customers.length; i++){
            int leftSatisfied = 0;
            if(i > 0) leftSatisfied = cummalativesSatisfied[i - 1];
            
            int rightSatisfied = 0;
            if(i + minutes < customers.length){
                rightSatisfied = sum - cummalativesSatisfied[i + minutes - 1];
            }
            
            int before = 0; 
            if(i > 0){
                before = cummalativeCustomer[i - 1];
            }
            int after = cummalativeCustomer[customers.length - 1];
            if(i + minutes < customers.length){
                after = cummalativeCustomer[i + minutes - 1];
            }
            int middle = after - before;
            
            
            max = Math.max(max, (leftSatisfied + rightSatisfied + middle));
        }
        
        return max;
    }
}