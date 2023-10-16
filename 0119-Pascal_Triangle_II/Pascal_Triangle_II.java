class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(new ArrayList<>(list));
        list.add(1);
        ans.add(new ArrayList<>(list));
        
        for(int i = 2; i <= rowIndex; i++){
            list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j < i; j++){
                list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        
        return ans.get(rowIndex);
    }
}