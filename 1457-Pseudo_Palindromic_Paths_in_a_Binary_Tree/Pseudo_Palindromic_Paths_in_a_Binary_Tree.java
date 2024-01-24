/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new int[10]);
        return count;
    }
    
    private void dfs(TreeNode root, int[] occur){
        if(root == null) return;
        if(root.left == null && root.right == null){
            occur[root.val]++;
            if(isPalindrome(occur)) count++;
            occur[root.val]--;
            return;
        }
        
        occur[root.val]++;
        dfs(root.left, occur);
        dfs(root.right, occur);
        occur[root.val]--;
    }
    
    private boolean isPalindrome(int[] occur){
        boolean hasOdd = false;
        for(int i = 1; i <= 9; i++){
            if(occur[i] % 2 == 1) {
                if(hasOdd) return false;
                hasOdd = true;
            }
        }
        
        return true;
    }
}