import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) {     
        HashMap<Integer, Integer> elements = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int element = arr[i] % k;
            if(element < 0) element = element + k;
            
            elements.put(element, elements.getOrDefault(element, 0) + 1);
        }
        
        
        for(Integer element: elements.keySet()){
            if(element == 0 || element * 2 == k){
                if(elements.get(element) % 2 != 0) return false;
            }
            else {
                if(!elements.containsKey(k - element) || !elements.get(element).equals(elements.get(k - element))) return false;
            }            
        }
        
        
        return true;
    }
}