
class DoubleANumberRepresentedAsALinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        int carry = 0;
        public ListNode doubleIt(ListNode head) {
            calculateNode(head);
            
            if(carry > 0){
                return new ListNode(carry, head);
            }
            return head;
        }
        
        private ListNode calculateNode(ListNode node){
            if(node == null) return node;
            
            node.next = calculateNode(node.next);
            
            int val = (node.val * 2) + carry;
            node.val = val % 10;
            
            if(val >= 10) carry = 1;
            else carry = 0;
            
            return node;
        }
    }
}
