class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    private void backTracking(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int index){
        if(target < 0) return;
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }        
        
         for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                
                list.add(candidates[i]);
                backTracking(ans, list, candidates, target - candidates[i], i + 1);                
                list.remove(list.size() - 1);
            }
    }
}