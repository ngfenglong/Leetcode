class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
        
        for(int i = 0; i < adjacentPairs.length; i++){
            int first  = adjacentPairs[i][0];
            int second  = adjacentPairs[i][1];
            
            if(!hm.containsKey(first)) hm.put(first, new Node(first));
            if(!hm.containsKey(second)) hm.put(second, new Node(second));
            
            hm.get(first).connected.add(hm.get(second));
            hm.get(second).connected.add(hm.get(first));
        }
        
        Node node = new Node();
        for(Integer key: hm.keySet()){
            if(hm.get(key).connected.size() == 1){
                node = hm.get(key);
                break;
            }
        }
        
        Set<Integer> set = new HashSet<Integer>();
        int[] ans = new int[adjacentPairs.length + 1];
        int i = 0;
        while(i < ans.length){
            set.add(node.val);
            ans[i++] = node.val;
            
            List<Node> connected = node.connected;
            for(Node n: connected){
                if(!set.contains(n.val)){
                    node = n;
                    break;
                }
            }
        }
        
        return ans;
    }
    
    class Node {
        List<Node> connected;
        int val;
        
        public Node(){
            connected = new ArrayList<>();
        }
        
        public Node(int val){
            this.val = val;
            connected = new ArrayList<>();
        }
    }
}