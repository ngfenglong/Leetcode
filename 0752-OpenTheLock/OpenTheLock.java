import java.util.*;

class OpenTheLock {
    class Solution {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> deadendSet = new HashSet<>();
        
        public int openLock(String[] deadends, String target) {
            for(String s: deadends){
                deadendSet.add(Integer.parseInt(s));
            }
            
            if(deadendSet.contains(0)) return -1;
            
            int[] targetNum = new int[4];
            for(int i = 0 ; i < target.length(); i++){
                int idxVal = target.charAt(i) - '0';
                targetNum[i] = idxVal;
            }
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,0,0});
            visited.add(0);
            
            int count = 0;
            while(!queue.isEmpty()){
                int tempCount = queue.size();
                while(tempCount > 0){
                    int[] num  = queue.poll();
                    
                    if(sameNumber(num, targetNum)) return count;
                            
                    for(int i = 0; i < 4; i++){
                        int[] deduct = calculate(num, i, false);
                        int[] add = calculate(num, i, true);
                        int deductVal = convertToInt(deduct);
                        int addVal = convertToInt(add);
                        
                        if(!(visited.contains(deductVal) || deadendSet.contains(deductVal))) {
                            visited.add(deductVal);
                            queue.add(deduct);   
                        }
                        if(!(visited.contains(addVal) || deadendSet.contains(addVal))){
                            visited.add(addVal);
                            queue.add(add);
                        } 
                    }
                    
                    tempCount--;
                }
                count++;
            }
            
            
            return -1;
        }
        
        private int[] calculate(int[] tempNum, int counter, boolean isAdd){
            int[] num = new int[]{tempNum[0],tempNum[1],tempNum[2],tempNum[3]};
            if(isAdd){
                if(counter == 3 && num[0] == 9) num[0] = 0;
                else if(counter == 2 && num[1] == 9) num[1] = 0;
                else if(counter == 1 && num[2] == 9) num[2] = 0;
                else if(counter == 0 && num[3] == 9) num[3] = 0;
                else num[3 - counter]++;
            }
            else{
                if(counter == 3 && num[0] == 0) num[0] = 9;
                else if(counter == 2 && num[1] == 0) num[1] = 9;
                else if(counter == 1 && num[2] == 0) num[2] = 9;
                else if(counter == 0 && num[3] == 0) num[3] = 9;
                else num[3- counter]--;
            }
            return num;
        }
     
        private boolean sameNumber(int[] num1, int[] num2){
            for(int i = 0; i < 4; i++){
                if(num1[i] != num2[i])return false;
            }
            return true;
        }
        
        private int convertToInt(int[] num){
            int n = num[0];
            for(int i = 1; i < 4; i++){
                n *= 10;
                n += num[i];
            }
            return n;
        }
    }
}
