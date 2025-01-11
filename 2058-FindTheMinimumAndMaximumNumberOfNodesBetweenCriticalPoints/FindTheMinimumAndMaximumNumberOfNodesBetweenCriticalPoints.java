
class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            ListNode curr = head;
            
            int prev = curr.val;
            curr = curr.next; 
            int idx = 0;
            
            int firstCP = -1;
            int prevCP = -1;
            int minGap = Integer.MAX_VALUE;
            
            while(curr.next != null){
                if((curr.val < prev && curr.val < curr.next.val) || (curr.val > prev && curr.val > curr.next.val)){
                    if(firstCP == -1) firstCP = idx;
                    if(prevCP > -1) minGap = Math.min(minGap, idx - prevCP);
                            
                    prevCP = idx;
                }
                
                prev = curr.val;
                curr = curr.next;
                idx++;
            }
            
            if(firstCP == -1 || (firstCP == prevCP)){
                return new int[]{-1,-1};
            }
            
            return new int[]{minGap, prevCP - firstCP};
            
        }
    }
}
