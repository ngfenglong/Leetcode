
class FindTheWinnerOfTheCircularGame {
    class Solution {
        public int findTheWinner(int n, int k) {
            // Add all into a circular linkedlist
            ListNode head = new ListNode(1);
            ListNode curr = head;
            for(int i = 2; i <= n; i++){
                ListNode temp = new ListNode(i);
                temp.prev = curr;
                curr.next = temp;
                curr = curr.next;
            }
            
            curr.next = head;
            head.prev = curr;
            
            for(int i = 1; i < n; i++){
                for(int j = 1; j < k; j++){
                    head = head.next;        
                }
                ListNode temp = head.next;
                head.remove(); 
                head = temp;
            }
            return head.val;
        }
        
        class ListNode {
            int val;
            ListNode next;
            ListNode prev;
            
            public ListNode(int val) {
                this.val = val;
            }
            
            public void remove(){
                this.next.prev = prev;
                this.prev.next = next;
            }
        }
    }
}
