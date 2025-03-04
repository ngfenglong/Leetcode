import java.util.*;

class NAryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    class Solution {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> postorder(Node root) {
            traverse(root);
            return ans;
        }
        
        private void traverse(Node root){
            if(root == null) return;
            if(root.children != null){
                for(Node n : root.children){
                    traverse(n);
                }    
            }
            
            ans.add(root.val);
        }
    }
}
