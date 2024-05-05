public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        getNodeVal(node);
    }
    
    private int getNodeVal(ListNode node){
        if(node.next == null){
            return node.val;
        }
        
        int tempVal = node.val;
        node.val = getNodeVal(node.next);
        if(node.val == node.next.val) node.next = null;
        return tempVal;
    }
}