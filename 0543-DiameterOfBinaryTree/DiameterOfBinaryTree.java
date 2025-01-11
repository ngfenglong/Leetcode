
class DiameterOfBinaryTree {
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
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            recursion(root);
            
            return ans;
        }
        
        private int recursion(TreeNode root){
            if(root == null) return 0;
            
            int left = 0;
            int right = 0;
            if(root.left != null){
                left = recursion(root.left) + 1;
            }
            
            if(root.right != null){
                right = recursion(root.right) + 1; 
            }
            
            ans = Math.max(ans, right + left);
            
            return Math.max(right, left);
        }
    }
}
