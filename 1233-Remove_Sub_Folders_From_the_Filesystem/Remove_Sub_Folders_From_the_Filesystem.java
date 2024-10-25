class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        
        TreeNode node = new TreeNode();
        
        for(int i = 0; i < folder.length; i++){
            TreeNode curr = node;
            String str = folder[i];
            
            String[] paths = str.split("/");
            
            for(int j = 1; j < paths.length; j++){                
                if(!curr.letters.containsKey(paths[j])) curr.letters.put(paths[j], new TreeNode());
                curr = curr.letters.get(paths[j]);
            }                
            
            curr.isLast = true;
        }
        
        populateMainFolders(ans, node, new StringBuilder());
        return ans;
    }
    
    private void populateMainFolders(List<String> ans, TreeNode node, StringBuilder sb){
        if(node == null) return;
        
        if(node.isLast){
            ans.add(sb.toString());
            return;
        }
        
        Set<String> paths = node.letters.keySet();
        
        for(String path: paths){
            if(node.letters.containsKey(path)) {
                sb.append("/");
                sb.append(path);
                populateMainFolders(ans, node.letters.get(path), sb);
                sb.delete((sb.length() - path.length() -1), sb.length());           
            }
        }
    }
    
    class TreeNode {
        HashMap<String, TreeNode> letters = new HashMap<>();
        boolean isLast = false;
        
        public TreeNode(){}
        
    }
}