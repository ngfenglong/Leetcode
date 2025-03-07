import java.util.*;

public class ClosestPrimeNumbersInRange {
    class Solution {
        public int[] closestPrimes(int left, int right) {
            List<Integer> primeList = new ArrayList<>();
            buildPrimeList(primeList, left, right);
            
            if(primeList.size() <= 1) return new int[]{-1,-1};
    
            int num1 = -1;
            int num2 = -1;
            int gap = Integer.MAX_VALUE;
            
            for(int i = 0; i < primeList.size() - 1; i++){
                if((primeList.get(i+1) - primeList.get(i)) < gap){
                    num1 = primeList.get(i);
                    num2 = primeList.get(i + 1);
                    gap = primeList.get(i+1) - primeList.get(i);
                }
            }
    
            return new int[]{num1, num2};
        }
    
        private void buildPrimeList(List<Integer> primeList, int left, int right){
            int limit = (int) (Math.ceil(Math.sqrt(right)));
            boolean[] primeArr = new boolean[right + 1];
            
            Arrays.fill(primeArr, true);
            
            primeArr[0] = false;
            primeArr[1] = false;
            for(int i = 2; i <= limit; i++){
                for(int j = i * i; j <= right; j += i){
                    primeArr[j] = false;
                }
            }
    
            for(int i = left ; i <= right; i++){
                if(primeArr[i]) primeList.add(i);
            }
        }
    
    }
}