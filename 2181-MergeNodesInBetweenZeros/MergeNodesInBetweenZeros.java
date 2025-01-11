
class MergeNodesInBetweenZeros {
    class ListNode {
        int val;
        ListNode next;
    
        ListNode() {
        }
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode newHead = new ListNode();
            ListNode newCurr = newHead;
    
            ListNode curr = head;
            curr = curr.next;
            while (curr != null) {
                int sum = 0;
                while (curr.val != 0) {
                    sum += curr.val;
                    curr = curr.next;
                }
    
                curr = curr.next;
    
                newCurr.next = new ListNode(sum);
                newCurr = newCurr.next;
            }
    
            return newHead.next;
        }
    }
}
