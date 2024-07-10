class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        
        for(int i = 0; i < logs.length; i++){
            if(logs[i].equals("./")){
                continue;
            }
            else if(logs[i].equals("../")){
                if(depth > 0) depth--;
            }
            else{
                depth++;
            }
        }
        return depth;
    }
}