
class InsertDeleteGetRandomO(1) {
    class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        
        public RandomizedSet() {
            
        }
        
        public boolean insert(int val) {
            if(hm.containsKey(val)) return false;
            
            hm.put(val, list.size());
            list.add(val);
            return true;
        }
        
        public boolean remove(int val) {
            if(!hm.containsKey(val)) return false;
            
            int idx = hm.get(val);
            swapAndRemoveLast(idx);
            
            hm.remove(val);
            return true;    
        }
        
        public int getRandom() {
            int rand = (int)Math.floor(Math.random() * list.size());
            return list.get(rand);
        }
        
        private void swapAndRemoveLast(int idx){
            int temp = list.get(list.size()-1);
            list.set(idx,temp);
            list.remove(list.size() - 1);
            
            hm.put(temp, idx);
        }
    }
}
