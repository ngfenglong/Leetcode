class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.offer(freq[i]);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int i = 0;
            Queue<Integer> tempQueue = new LinkedList<>(); while(i <= n){
                if(!queue.isEmpty()){
                    int taskCount = queue.poll();
                    if(taskCount > 1){
                        tempQueue.add(taskCount - 1);
                    }
                    count++;
                }
                
                else if(!queue.isEmpty() || !tempQueue.isEmpty()){
                    count++;
                }
                i++;
            }
            
            while(!tempQueue.isEmpty()){
                queue.add(tempQueue.poll());
            }
        }
        
        return count;
    }
}