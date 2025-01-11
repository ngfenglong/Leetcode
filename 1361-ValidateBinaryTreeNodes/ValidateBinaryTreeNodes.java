import java.util.*;

class ValidateBinaryTreeNodes {
    
    class Solution {
        HashMap<Integer, Node> hm = new HashMap<>();
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            int[] incoming =  new int[n];
            Arrays.fill(incoming, -1);
            
            populateTree(n, leftChild, rightChild, incoming);
            
            Node head = getHead(n, incoming);
            
            if(head == null) return false;
            
            return isValidBinaryTree(head, new boolean[n]);
        }
    
        private boolean isValidBinaryTree(Node head, boolean[] visited){
            Queue<Node> queue = new LinkedList();
            queue.add(head);
            
            while(!queue.isEmpty()){
                Node curr = queue.poll();
                if(visited[curr.val]) return false;
                
                visited[curr.val] = true;
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]) return false;
            }
            
            return true;
        }
        
        
        private Node getHead(int n, int[] incoming){
            int headIdx = -1;
            for(int i = 0 ; i < n; i++) {
                if(incoming[i] == -1){
                    if(headIdx != -1){
                        return null;
                    }
                    headIdx = i;
                }
            }
            return hm.get(headIdx);
        }
        
        private void populateTree(int n, int[] leftChild, int[] rightChild, int[] incoming){
              for(int i = 0; i < n; i++){
                if(!hm.containsKey(i)){
                    hm.put(i, new Node(i));
                }
                
                Node curr = hm.get(i);
                
                int left = leftChild[i];
                int right = rightChild[i];
                
                if(left != -1){
                    if(!hm.containsKey(left)){
                        hm.put(left, new Node(left));
                    }
                    incoming[left] = i;
                    curr.left = hm.get(left);
                }
                
                if(rightChild[i] != -1){
                    if(!hm.containsKey(right)){
                        hm.put(right, new Node(right));
                    }   
                    incoming[right] = i;
                    curr.right = hm.get(right);
                }
            }
        }
        
    
        
        private class Node {
            Node left;
            Node right;
            int val;
            
            public Node(int val){
                this.val = val;
            }
        }
    }
}
