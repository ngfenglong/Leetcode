class MyQueue {
    Stack<Integer> stack = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        flipStack();
        int val = stack.pop();
        flipStack();
        
        return val;
    }
    
    public int peek() {
        flipStack();
        int val = stack.peek();
        flipStack();
        
        return val;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
    
    private void flipStack(){
        Stack<Integer> temp = new Stack<Integer>();
        while(!this.stack.isEmpty()){
            temp.push(this.stack.pop());
        }
        
        this.stack = temp;
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */