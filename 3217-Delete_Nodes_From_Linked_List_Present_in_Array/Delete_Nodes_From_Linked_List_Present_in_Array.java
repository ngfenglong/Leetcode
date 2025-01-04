import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toRemoveSet = new HashSet<>();
        for(int num: nums){
            toRemoveSet.add(num);
        }
        
        ListNode newHead = new ListNode(-1, head);
        ListNode curr = newHead;
        
        while(curr != null){
            if(curr.next != null && toRemoveSet.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        
        return newHead.next;
    }
}