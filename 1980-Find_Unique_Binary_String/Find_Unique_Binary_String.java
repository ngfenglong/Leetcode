import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        Node head = new Node();
        // Fit into a Trie data structure
        for(int i = 0; i < nums.length; i++){
            String s = nums[i];
            set.add(s);
            Node curr = head;
            for(int j = 0; j < s.length(); j++){
                int val = s.charAt(j) - '0';
                if(curr.nodes[val] == null){
                    curr.nodes[val] = new Node();
                }
                curr = curr.nodes[val];
            }
        }
        
        set.add("x");
        String ans = dfs(head, nums.length, new StringBuilder());
        return ans;
    }
    
    private String dfs(Node node, int n, StringBuilder sb){
        if(sb.length() == n) {
            return sb.toString();
        }
        
        if(node == null){
            for(int i = sb.length(); i < n; i++){
                sb.append("0");
            }
            return sb.toString();
        }
        
        sb.append("0");
        String s1 = dfs(node.nodes[0], n, sb);
        if(!set.contains(s1)) return s1;
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append("1");
        String s2 = dfs(node.nodes[1], n, sb);
        if(!set.contains(s2)) return s2;
        sb.deleteCharAt(sb.length() - 1);
        
        return "x";
    }
    
    class Node{
        Node[] nodes = new Node[2];
        
        public Node(){
            
        }
    }
}