class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toSkip = new HashSet<>();
        Stack<Integer> openBrackets = new Stack<>();
        
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                openBrackets.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(openBrackets.size() == 0){
                    toSkip.add(i);
                }else{
                    openBrackets.pop();
                }
            }
        }
        
        while(!openBrackets.isEmpty()){
            toSkip.add(openBrackets.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!toSkip.contains(i)){
                sb.append(s.charAt(i));
            }
        }
            
        return sb.toString();
            
    }
}