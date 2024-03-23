public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode curr; 
    ListNode lastNode;
    public void reorderList(ListNode head) {
        curr = head;
        lastNode = findLastNode(head);
        
        reOrder(head);
    }
    
    private void reOrder(ListNode node){
        if(node == null) return;
        reOrder(node.next);
        if(curr == lastNode) {
            curr.next = null;
            return;
        }
        if(node == lastNode){
            node.next = null;
            return;
        }
        
        ListNode tempCurr = curr.next;
        curr.next = node;
        node.next = tempCurr;
        curr = tempCurr;    
    }
    
    private ListNode findLastNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}