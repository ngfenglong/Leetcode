import java.util.*;

class FindLargestValueInEachTreeRow {
    
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            
            if(root == null) return ans;
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            
            while(!queue.isEmpty()){
                int n = queue.size();
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < n; i++){
                    TreeNode node = queue.poll();
                    max = Math.max(max, node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                ans.add(max);
            }
            
            return ans;
        }
    }
}
