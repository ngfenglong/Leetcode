
class InsertGreatestCommonDivisorsInLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode curr = head;
            while(curr != null && curr.next != null){
                int divisor = gcd(curr.val, curr.next.val);
                curr.next = new ListNode(divisor, curr.next);
                curr = curr.next.next;
            }
            
            return head;
        }
        
        private int gcd(int i1, int i2){
            while(i2 != 0){
                int temp = i2;
                i2 = i1 % i2;
                i1 = temp;
            }
            
            return i1;
        }
    }
}
