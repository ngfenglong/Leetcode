class CustomStack {
    int counter = 0;
    int maxSize = 0;
    int[] stack;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(counter < maxSize) {
            stack[counter++] = x;
        }
    }
    
    public int pop() {
        if(counter == 0) return -1;
        
        return stack[--counter]; 
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, counter); i++){
            stack[i] += val;
        }
    }
}
