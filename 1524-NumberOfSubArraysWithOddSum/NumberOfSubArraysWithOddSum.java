public class NumberOfSubArraysWithOddSum {
    class Solution {
        int MODULO = (int)(1e9 + 7);
        public int numOfSubarrays(int[] arr) {
            int[] evenDP = new int[arr.length + 1];
            int[] oddDP = new int[arr.length + 1];
            int count = 0;
        
            for(int i = arr.length - 1 ; i >= 0; i--){
                if(arr[i] % 2 == 1){
                    oddDP[i] = evenDP[i + 1] + 1;
                    evenDP[i] = oddDP[i + 1];
                }
                else {
                    evenDP[i] = evenDP[i + 1] + 1;
                    oddDP[i] = oddDP[i + 1];
                }
                count = (count + oddDP[i]) % MODULO;
            }
    
            return count;
        }
    }
}