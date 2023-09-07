class Solution {
    ListNode nodeAfterReversedEnd;
    ListNode reversedStart;
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;  // No change is required
        
        ListNode temp = head;   // If the first node needs to be reverse, create a placeHolder previous node
        if(left == 1) {
            temp = new ListNode();
            temp.next = head;
        }
        
        ListNode newHead = temp;    
        for(int i = 1; i < left - 1; i++){
            temp = temp.next;       // Traverse to the node before the swap take place
        }
        
        ListNode reverseEnd = reverseNodes(temp.next, (right - left));  // Get the last node after reverse
        reverseEnd.next = nodeAfterReversedEnd; 
        temp.next = reversedStart; 
        
        return left == 1 ? newHead.next : newHead;
    }
    
    // method to reverse
    private ListNode reverseNodes(ListNode node, int count){
        if(count == 0){
            nodeAfterReversedEnd = node.next;
            reversedStart = node;
            return node;
        }
        count--;
        reverseNodes(node.next, count).next = node;

        return node;
    }
}