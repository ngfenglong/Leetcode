class Solution {
    public int countTriplets(int[] arr) {
        // i < j <= k
        HashMap<Integer,List<List<Integer>>> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            hm.put(i, new ArrayList<>());
            for(int j = 0; j < i; j++){
                List<List<Integer>> list = hm.get(j);
                List<Integer> l = new ArrayList<>();
                l.add(i); //
                l.add(list.get(list.size() - 1).get(1) ^ arr[i]);
                list.add(l);
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(i);// ending index
            list.add(arr[i]); // value
            hm.get(i).add(list);
        }
        
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            List<List<Integer>> list1 = hm.get(i);
            for(List<Integer> l: list1){
                int aEndIdx = l.get(0);
                int val = l.get(1);
                if(aEndIdx < arr.length - 1){
                    List<List<Integer>> list2 = hm.get(aEndIdx + 1);
                
                    for(List<Integer> l2: list2){
                        if(l2.get(1) == val) count++;
                    }    
                }
            }
        }
        
        return count;
    }
    
    
}