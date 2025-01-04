class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        
        return check(head);
    }
    
    private boolean check(ListNode curr){
        if(curr != null){
            if(!check(curr.next)) return false;
            if(start.val != curr.val) return false;
            start = start.next;
        }
        return true;
    }
}