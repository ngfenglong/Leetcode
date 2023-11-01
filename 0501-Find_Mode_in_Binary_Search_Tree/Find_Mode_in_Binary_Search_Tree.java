public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    HashMap<Integer,Integer> hm = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        getOccurrence(root);
        List<Integer> ans = new ArrayList<Integer>();
        
        for(Integer i: hm.keySet()){
            if(hm.get(i) == max){
                ans.add(i);
            }
        }
        
        int[] ansArr = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
    
    private void getOccurrence(TreeNode root){
        if(root == null) {
            return;
        }
        
        int curr = hm.getOrDefault(root.val, 0) + 1;
        hm.put(root.val, curr);
        max = Math.max(max, curr);
        
        getOccurrence(root.left);
        getOccurrence(root.right);
    }
}