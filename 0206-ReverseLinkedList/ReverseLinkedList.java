
class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            
            while(head != null){
                newHead = new ListNode(head.val, newHead);
                head = head.next;
            }
            
            return newHead;
        }
    }
}
