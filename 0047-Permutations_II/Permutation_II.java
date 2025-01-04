import java.util.*;
class Solution {
    HashMap<String, List<Integer>> hm = new HashMap<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        
        
        // Call recusive method to populate HM
        recursive(visited, nums, new StringBuilder(), new ArrayList<>());
        
        List<List<Integer>> ans = new ArrayList<>();
        // For each key in hm --> List<List<Integer>>
        for(String key: hm.keySet()){
            ans.add(hm.get(key));
        }
        
        return ans;
    }
    
    private void recursive(boolean[] visited, int[] nums, StringBuilder sb, List<Integer> list){
        if(list.size() == nums.length){
            hm.put(sb.toString(), new ArrayList<>(list));
            return;
        }
        
        for(int i = 0 ; i < nums.length; i++){
            if(visited[i] == false){
                int num = nums[i];
                String strNum = ""  + num;
                
                visited[i] = true;
                list.add(nums[i]);
                sb.append(nums[i]);
                
                recursive(visited, nums, sb, list);
                
                visited[i] = false;
                list.remove(list.size() - 1);
                sb.delete(sb.length() - strNum.length(), sb.length());
            }
        }
        
    }
}