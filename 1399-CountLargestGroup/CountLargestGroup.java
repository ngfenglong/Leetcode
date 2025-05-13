import java.util.*; 

public class CountLargestGroup {
    class Solution {
        public int countLargestGroup(int n) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                int sum = 0;
                int temp = i;
                while (temp != 0) {
                    sum += (temp % 10);
                    temp /= 10;
                }

                freq.put(sum, freq.getOrDefault(sum, 0) + 1);
            }

            int largestGrp = 0;
            int occur = 0;
            for (int key : freq.keySet()) {
                if (freq.get(key) > largestGrp) {
                    occur = 1;
                    largestGrp = freq.get(key);
                } else if (freq.get(key) == largestGrp) {
                    occur++;
                }

            }

            return occur;
        }
    }

}