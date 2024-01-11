












 
class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        checkDiff(root, root.val, root.val);
        
        return ans;
    }
    
    private void checkDiff(TreeNode root, int max, int min){
        if(root == null) return;
        
        ans = Math.max(ans, Math.abs(root.val - max));
        ans = Math.max(ans, Math.abs(root.val - min));
        
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        checkDiff(root.left, max, min);
        checkDiff(root.right, max, min);
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