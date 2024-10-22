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

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int count = queue.size();
            long sum = 0l;
            
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                sum +=  (long)node.val;
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
                
            pq.add(sum);
            if(pq.size() > k) pq.poll();
        }
        
        
        if(pq.size() < k) return -1;
        
        return pq.poll();
    }
}