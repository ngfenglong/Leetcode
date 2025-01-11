
class SumRootToLeafNumbers {
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
        public int sumNumbers(TreeNode root) {
            addTree(root, 0);
            return sum;
        }
        
        private void addTree(TreeNode node, int val){
            if(node == null) return;
            if(node.left == null && node.right == null){
                val = (val * 10) + node.val;
                sum += val;            
                return;
            }
            
            val = (val * 10) + node.val;
            addTree(node.left, val);
            addTree(node.right, val);
        }
    }
}
