import java.util.*;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> mapping = new HashMap<>();
        
        Node newHead = new Node(head.val);
        Node newTemp = newHead;
        Node temp = head;
        mapping.put(head, newHead);
        
        while(temp.next != null){
            newTemp.next = new Node(temp.next.val);
            
            temp = temp.next;
            newTemp = newTemp.next;
            mapping.put(temp, newTemp);
        }
        
        temp = head;
        newTemp = newHead;
        while(temp != null){
            if(temp.random != null){
                newTemp.random = mapping.get(temp.random);
            }
            
            newTemp = newTemp.next;
            temp = temp.next;
        }
        
        return newHead;
    }
}