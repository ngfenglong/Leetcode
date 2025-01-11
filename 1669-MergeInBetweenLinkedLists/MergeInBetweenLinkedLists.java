
class MergeInBetweenLinkedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode nodeA = findIndex(list1, a - 1);
            ListNode nodeB = findIndex(list1, b);
            ListNode node2End = findLast(list2);
            
            node2End.next = nodeB.next;
            if(a == 0){
                return list2;
            }
            
            nodeA.next = list2;
            return list1;
        }
        
        private ListNode findIndex(ListNode node, int idx){
            int i = 0;
            
            while(i < idx){
                node = node.next;
                i++;
            }
            
            return node;
        }
        
        private ListNode findLast(ListNode node){
            if (node == null) return null;
            
            while(node != null && node.next != null){
                node = node.next;
            }
            
            return node;
        }
    }
}
