class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        Integer[] numsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numsInteger, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if(hm.get(i1) == hm.get(i2)){
                    return Integer.compare(i2,i1);
                }
                else{
                    return Integer.compare(hm.get(i1), hm.get(i2));
                }
            }
        });
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = numsInteger[i];
        }
           
        return nums;
    }
}