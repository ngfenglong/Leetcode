
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode front = new ListNode(0, head);
            ListNode start = front;
            
            while(start != null){
                ListNode end = start.next;
                int total = 0;
                while(end != null){
                    total += end.val;
                    if(total == 0){
                        start.next = end.next;
                    }
                    end = end.next;
                }
                
                start = start.next;
            }
            
            return front.next;
        }
    }
    
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
