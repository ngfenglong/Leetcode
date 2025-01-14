import java.util.*;

public class FindThePrefixCommonArrayOfTwoArrays{
    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            int[] ans = new int[n];
    
            Set<Integer> ACombi = new HashSet<>();
            Set<Integer> BCombi = new HashSet<>();
    
            int count = 0;
            for(int i = 0; i < n ; i++){
                if(A[i] == B[i]) count++;
                if(ACombi.contains(B[i])) count++;
                if(BCombi.contains(A[i])) count++;
    
                ACombi.add(A[i]);
                BCombi.add(B[i]);
    
                ans[i] = count;
            }
    
            return ans;
        }
    }
} 
