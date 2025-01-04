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
    int ans = -1;
    int maxDepth = -1;
    public int findBottomLeftValue(TreeNode root) {
        
        checkBottomLeft(root, 0);
        
        return ans;
    }
    
    private void checkBottomLeft(TreeNode root, int level){
        if(root == null) return;
        
        if(level > maxDepth){
            ans = root.val;
            maxDepth = level;
        }
        
        checkBottomLeft(root.left, level + 1);
        checkBottomLeft(root.right, level + 1);
    }
}