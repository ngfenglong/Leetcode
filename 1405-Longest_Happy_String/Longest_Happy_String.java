class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // 0 - a, 1 - b, 2 -c
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(b[0], a[0]);
            }
        });
                                                         
        if(a > 0) queue.add(new int[]{a, 0});
        if(b > 0) queue.add(new int[]{b, 1});
        if(c > 0) queue.add(new int[]{c, 2});
                                                         
        
        StringBuilder sb = new StringBuilder();
                                                         
        int lastLetter = -1;
        int lastFreq = -1;
                                                         
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            char currentChar = (char) ('a' + curr[1]);

            if(lastLetter == currentChar) return sb.toString();
            
            int count = Math.min(curr[0], 2);
            for(int i = 0; i < count; i++){
                curr[0]--;
                sb.append(currentChar);
            }
            
            
            if(queue.isEmpty()) return sb.toString();
            
            int[] next = queue.poll();
            char nextChar = (char) ('a' + next[1]);
            if(next[0] >= curr[0] && next[0] > 1) {
                next[0] --;
                sb.append(nextChar);
            }
            next[0] --;
            sb.append(nextChar);
            
            lastLetter = nextChar;
            lastFreq = next[0];
            
            if(next[0] > 0) queue.add(next);
            if(curr[0] > 0) queue.add(curr);
        }
        
        return sb.toString();
    }
}