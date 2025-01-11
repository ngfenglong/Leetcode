
class SumOfLeftLeaves {
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
        int sum = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root, false);
            return sum;
        }
        
        private void traverse(TreeNode root, boolean isLeft){
            if(root == null) return;
            
            if(root.left == null && root.right == null && isLeft){
                sum += root.val;
                return;
            }
            
            traverse(root.left, true);
            traverse(root.right, false);
            
        }
    }
}
