import java.util.*;

public class LengthOfLongestFibonacciSubsequence {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for(int i: arr){
                set.add(i);
            }
    
            int n = arr.length;
            int maxLen = 0;
            int first;
            int second;
            for(int i = 0; i < n - 2; i++){
                first = arr[i];
                for(int j = i + 1; j < n - 1; j++){
                    second = arr[j];
                    if(set.contains(first + second)){
                        int len = checkFib(first, second, set);
                        maxLen = Math.max(len, maxLen);
                    }
                }
            }
    
            return maxLen;        
        }
    
        private int checkFib(int first, int second, Set<Integer> set){
            int len = 2;
            while(set.contains(first + second)){
                len++;
                int temp = first + second;
                first = second;
                second = temp;
            }
    
            return len;
        }
    }
    
}