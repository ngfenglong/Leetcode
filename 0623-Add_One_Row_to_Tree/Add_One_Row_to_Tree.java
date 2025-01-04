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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }        
        
        addRow(root, val, depth, 1);
        return root;
    }
    
    private void addRow(TreeNode node, int val, int depth, int currLvl){
        if(node == null || currLvl >= depth) return;
        
        if(depth == currLvl + 1){
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
            return;
        }
        else{
            addRow(node.left, val, depth, currLvl + 1);
            addRow(node.right, val, depth, currLvl + 1);
        }    
    }
}