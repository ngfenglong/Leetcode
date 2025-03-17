public class HappyNumber {
    class Solution {
        private int getNext(int n){
            int sum = 0;
            while(n != 0){
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            return sum;
        }
    
        public boolean isHappy(int n) {
            int fast = getNext(getNext(n));
            int slow = getNext(n);
    
            if(slow == 1) return true;
    
            while(fast != 1 && fast != slow){
                fast = getNext(getNext(fast));
                slow = getNext(slow);
            }
            
            return fast == 1;
        }
    }
}