
class DesignHashMap {
    class MyHashMap {
        int size = 10001;
        Node[] list = new Node[size];
        public MyHashMap() {
                    
        }
        
        public void put(int key, int value) {
            int hashed = key % size;
            if(list[hashed] == null) {
                list[hashed] = new Node(key, value);
                return;
            }
            
            Node node = list[hashed];
            while(node.next != null && node.key != key){
                node = node.next;
            }
            if(node.key == key){
                node.value = value;  
            } 
            else{
                node.next = new Node(key, value);
            }
            
        }
        
        public int get(int key) {
            int hashed = key % size;
            if(list[hashed] == null) {
                return -1;
            }
            
            Node node = list[hashed];
            while(node.next != null && node.key != key){
                node = node.next;
            }
            
            if(node.key == key){
                return node.value;  
            } 
            
            return -1;
        }
        
        public void remove(int key) {
            int hashed = key % size;
            if(list[hashed] == null) {
                return;
            }
            
            Node node = list[hashed];
            
            if(node.key == key) {
                list[hashed] = node.next;
                return;
            }
            
            while(node.next != null && node.next.key != key){
                node = node.next;
            }
            
            if(node.next == null) return;
            
            node.next = node.next.next;
        }
        
        
        class Node {
            int value;
            int key;
            Node next;
            
            public Node(int key, int value){
                this.key = key;
                this.value = value;
                next = null;
            }
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}
