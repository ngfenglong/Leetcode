import java.util.*;

class LRUCache {
    
    HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            int val = node.val;
            
            removeNode(node);
            addNode(node);
            
            return val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        }
        else {
            Node node = new Node(key, value);
            if(capacity > 0){
                addNode(node);
                capacity--; 
            } 
            else {
                Node toRemove = head;
                removeNode(toRemove);
                addNode(node);
            }
        }
    }       
    
    private void removeNode(Node node){
        // is head
        if(node != head && node != tail){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else {
            if(node == head) {
                head = head.next;
                if(head != null) head.prev = null;
            }
            if(node == tail){
                tail = tail.prev;
                if(tail != null) tail.next = null;
            }            
        }
        
        node.prev = null;
        node.next = null;
        hm.remove(node.key);
    }
    
    private void addNode(Node node){
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        
        hm.put(node.key, node);
    }
    
    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

