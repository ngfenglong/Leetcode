class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        binarySearch(root, low, high);
        return sum;
    }
    
    private void binarySearch(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val < low){
            binarySearch(root.right, low, high);
        } else if (root.val > high) {
            binarySearch(root.left, low, high);
        } else {
            sum += root.val;
            binarySearch(root.left, low, high);
            binarySearch(root.right, low, high);
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