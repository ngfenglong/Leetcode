class Solution {
    public int maximumGain(String s, int x, int y) {
        char c1 = x > y ? 'a' : 'b';
        char c2 = x > y ? 'b' : 'a';
        
        int points = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == c1 && s.charAt(i) == c2){
                stack.pop();
                points += Math.max(x,y);
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        
        Stack<Character> tempStack = new Stack<>();
        while(!stack.isEmpty()) tempStack.push(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        while(!tempStack.isEmpty()) sb.append(tempStack.pop());
        
        for(int i = 0; i < sb.length(); i++){
            if(!stack.isEmpty() && stack.peek() == c2 && sb.charAt(i) == c1){
                stack.pop();
                points += Math.min(x,y);
            }
            else{
                stack.push(sb.charAt(i));
            }
        }
        
        return points;
    }
}