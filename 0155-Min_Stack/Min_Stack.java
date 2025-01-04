import java.util.*;
class MinStack {
    Stack<Node> stack = new Stack<>();
    Node min;
    public MinStack() {
        
    }
    
    public void push(int val) {
        Node n = new Node(val);
        if(min == null){
            min = n;
        } 
        else {
            if(min.val > val){
                n.next = min;
                min = n;
            }
        }
        stack.push(n);
    }
    
    public void pop() {
        if(stack.peek() == min){
            min = min.next;
        }
        
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return min.val;
    }
}

class Node {
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }
    
    public Node(Node next, int val){
        this.val = val;
        this.next = next;
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */