
class SumOfPrefixScoresOfStrings {
    class Solution {
        
        public int[] sumPrefixScores(String[] words) {
            TreeNode node = new TreeNode();
            
            for(String word: words){
                TreeNode curr = node;
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    if(curr.next[c - 'a'] == null){
                        curr.next[c - 'a'] = new TreeNode(c, 1);
                    }
                    else {
                        curr.next[c - 'a'].value++;
                    }
                    curr = curr.next[c - 'a'];
                }
            }
            
            int[] ans = new int[words.length];
            
            for(int i = 0; i < words.length; i++){
                TreeNode curr = node;
                String word = words[i];
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    ans[i] += curr.next[c-'a'].value;
                    curr = curr.next[c - 'a'];
                }
            }
                
            return ans;
        }
        
        
        class TreeNode {
            char key;
            int value;
            TreeNode[] next;
            
            public TreeNode(){
                next = new TreeNode[26];            
            }
            
            public TreeNode(char key, int value){
                this.key = key;
                this.value = value;
                next = new TreeNode[26];            
            }
        }
        
    }
}
