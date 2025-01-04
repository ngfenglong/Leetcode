import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((d1,d2)->  Double.compare(d2[2], d1[2]));
           
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                pq.add(new double[]{arr[i], arr[j], ((double)arr[i]/arr[j])});
                if(pq.size() > k) pq.poll();
            }
        }
        
        double[] pqArr = pq.poll();
        int[] ans = new int[]{(int)pqArr[0], (int)pqArr[1]};
        return ans;
    }
}