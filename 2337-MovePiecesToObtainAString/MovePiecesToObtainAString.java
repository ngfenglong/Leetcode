
class MovePiecesToObtainAString {
    class Solution {
        public boolean canChange(String start, String target) {
            int n = start.length();
            int sPointer = 0;
            int tPointer = 0;
            
            // Check L 
            while(tPointer < n || sPointer < n){
                while(tPointer < n && target.charAt(tPointer) == '_') tPointer++;
                
                while(sPointer < n && start.charAt(sPointer) == '_') sPointer++;
                
                // If traverse through on side, check if the other side still has an element or not
                if(sPointer == n || tPointer == n) return sPointer == tPointer;
                
                if(start.charAt(sPointer) != target.charAt(tPointer) ||
                   (target.charAt(tPointer) == 'L' && sPointer < tPointer) ||
                   (target.charAt(tPointer) == 'R' && tPointer < sPointer)
                  ){
                     return false;
                }
                
                sPointer++;
                tPointer++;
            }
            
            return true;
        }
    }
}
