import java.util.*;

class TwoSumIII {
    class TwoSum {
        HashMap<Integer, Integer> hm = new HashMap<>();
        public TwoSum() {
            
        }
        
        public void add(int number) {   
            hm.put(number, hm.getOrDefault(number, 0) + 1);        
        }
        
        public boolean find(int value) {
            for(int key: hm.keySet()){
                if(key + key == value){   
                    if(hm.get(key) >= 2) return true;
                }
                else if (hm.containsKey(value - key)) return true;
            }
            
            return false;
        }
    }
    
    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
}
