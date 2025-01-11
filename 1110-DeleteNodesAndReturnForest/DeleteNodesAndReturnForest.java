import java.util.*;

class DeleteNodesAndReturnForest {
    
    class TreeNode {
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
        List<TreeNode> ans = new ArrayList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> toDelete = new HashSet<>();
            for(int i : to_delete){
                toDelete.add(i);
            }
            
            if(!toDelete.contains(root.val)){
                ans.add(root);
            }
            
            checkTree(root, toDelete);
            
            return ans;
        }
        
        private void checkTree(TreeNode root, Set<Integer> toDelete){
            if(root == null) return;
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            if(toDelete.contains(root.val)){
                if(root.left != null && !toDelete.contains(root.left.val)) ans.add(root.left);
                if(root.right != null && !toDelete.contains(root.right.val)) ans.add(root.right);
                
                root.left = null;
                root.right = null;
            }
            
            
            if(left != null && toDelete.contains(left.val)) root.left = null;
            if(right != null && toDelete.contains(right.val)) root.right = null;
            checkTree(left, toDelete);
            checkTree(right, toDelete);
        }
    }
}
