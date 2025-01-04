import java.util.*;

class Solution {
    int ans = 0; 
    public int maxLength(List<String> arr) {
        // each element -> unique characters
        // to select whether to pick or not to pick, -> if it contains duplicate, cannot pick
        List<String> listWithNoDups = removeDuplicate(arr);
        checkMax(listWithNoDups, new HashSet<>(), 0);
        
        return ans;
    }
    
    private void checkMax(List<String> arr, Set<Character> set, int idx){
        if(idx >= arr.size()){
            ans = Math.max(ans, set.size());
            return;
        }

        String s = arr.get(idx);
        if(!containsDuplicate(set, s)){
            addToSet(set, s);
            checkMax(arr, set, idx + 1);
            removeFromSet(set, s);
        }
        checkMax(arr, set, idx + 1);
    }
    
    private boolean containsDuplicate(Set<Character> set, String s) {
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))) return true;
        }
        return false;
    }
    
    private void addToSet(Set<Character> set, String s){
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
    }
    
    private void removeFromSet(Set<Character> set, String s){
        for(int i = 0; i < s.length(); i++){
            set.remove(s.charAt(i));
        }
    }
    
    private List<String> removeDuplicate(List<String> list) {
        List<String> listWithNoDups = new ArrayList<>();
        
        for(String s: list){
            boolean containsDup = false;
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++){
                if(set.contains(s.charAt(i))){
                    containsDup = true;
                    break;
                }
                else {
                    set.add(s.charAt(i));
                }
            }
            if(!containsDup) {
                listWithNoDups.add(s);
            }
        }
        
        return listWithNoDups;
    }
}