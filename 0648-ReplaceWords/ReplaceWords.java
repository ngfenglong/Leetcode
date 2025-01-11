import java.util.*;

class ReplaceWords {
    
    class Solution {
        
        TreeNode dic = new TreeNode();
        public String replaceWords(List<String> dictionary, String sentence) {
    
            fillDictionary(dictionary);
            
            String[] strs = sentence.split(" ");
            for(int i = 0; i < strs.length; i++){
                strs[i] = findRoot(strs[i]);
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < strs.length; i++){
                if(i > 0) sb.append(" ");
                sb.append(strs[i]);
            }        
            
            return sb.toString();
        }
        
        private void fillDictionary(List<String> dictionary){
            for(String s : dictionary){
                TreeNode temp = dic;
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    if(temp.nodes[c - 'a'] == null){
                        temp.nodes[c - 'a'] = new TreeNode(c);
                    }
                    temp = temp.nodes[c-'a'];
                }
                temp.isLast = true;
            }
        }
        
        private String findRoot(String s){
            TreeNode temp = dic;
            for(int i = 0; i < s.length(); i++){
                if(temp.nodes[s.charAt(i) - 'a'] != null){
                    temp = temp.nodes[s.charAt(i) - 'a'];                
                    if(temp.isLast) return s.substring(0, i + 1);
                }
                else {
                    return s;   
                }
            }
            return s;
        }
        
        
        class TreeNode {
            TreeNode[] nodes = new TreeNode[26];
            char val;
            boolean isLast = false;
            
            public TreeNode(){            
            }
            
            public TreeNode(char c){
                this.val = c;
            }
        }
    }
}
