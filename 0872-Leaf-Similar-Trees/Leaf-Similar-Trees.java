
import java.util.*;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        getRoots(root1, list1);
        getRoots(root2, list2);

        if(list1.size() != list2.size()) return false;
        
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)) return false;
        }
        
        return true;
    }
    
    private void getRoots(TreeNode root, List<Integer> list){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        else{
            getRoots(root.left, list);
            getRoots(root.right, list);
        }
        
    }

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

}