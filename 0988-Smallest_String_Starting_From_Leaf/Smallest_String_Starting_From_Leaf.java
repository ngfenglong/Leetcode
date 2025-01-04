import java.util.*;
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
    PriorityQueue<String> pq;
    
    public String smallestFromLeaf(TreeNode root) {
        pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
        
        collateList(root, new StringBuilder());
        if(pq.isEmpty()) return "";
        
        return pq.poll();
        
    }
    
    private void collateList(TreeNode node, StringBuilder sb){
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            sb.append((char)('a' + node.val));           
            pq.add(reverseStr(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char)('a' + node.val));
        collateList(node.left, sb);
        collateList(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    
    private String reverseStr(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}