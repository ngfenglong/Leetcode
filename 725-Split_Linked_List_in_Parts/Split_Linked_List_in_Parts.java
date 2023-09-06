class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        if(head == null) return arr;
        
        int count = 0; 
        
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        int nodePerArr = count / k;
        int extra = count % k;
        
        temp = head;
        
        for(int i = 0; i < k; i ++){    // each arr 
            ListNode arrHeadNode = temp;
            ListNode curr = arrHeadNode;

            for(int j = 0; j < nodePerArr + (extra > 0 ? 1 : 0) - 1; j++){  
                curr = curr.next;
            }   
            
            temp = curr;
            if(curr != null){
                temp = temp.next;
                curr.next = null;
            }

            arr[i] = arrHeadNode;
            extra--;
        }
        
        return arr;
    }
}