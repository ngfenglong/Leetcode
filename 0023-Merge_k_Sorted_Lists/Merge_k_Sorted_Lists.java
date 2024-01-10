
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Do a merge sort on the list
            // partition -> Left, mid, right
            // Helper method -> merge 2 lists
        if(lists.length == 0) return null;
        
        return partition(lists, 0, lists.length - 1);
        
        
    }
    
    private ListNode partition(ListNode[] lists, int left, int right){
        if(right <= left) return lists[right];
        
        int mid = (left + right)/2;
        ListNode node1 = partition(lists, left, mid);
        ListNode node2 = partition(lists, mid + 1, right);
        
        return merge2Lists(node1, node2);
    }
    
    private ListNode merge2Lists(ListNode node1, ListNode node2){
        ListNode node = new ListNode();
        ListNode curr = node;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val){
                curr.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                curr.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            curr = curr.next;            
        }
        
        if(node1 != null){
            curr.next = node1;
        }
        if(node2 !=
         null){
            curr.next = node2;
        }
        
        return node.next;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }   
}