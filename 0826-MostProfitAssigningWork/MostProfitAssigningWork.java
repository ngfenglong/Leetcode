import java.util.*;

class MostProfitAssigningWork {
    
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            
            Task[] tasks = new Task[n];
            
            for(int i = 0; i < n; i++){
                tasks[i] = new Task(difficulty[i], profit[i]);
            }
            
            
            // Sort task based on difficulty -> Profit
            Arrays.sort(tasks, new Comparator<Task>(){
                public int compare(Task t1, Task t2){
                    if(t1.difficulty == t2.difficulty){
                        return Integer.compare(t2.profit, t1.profit);
                    }
                    return Integer.compare(t1.difficulty, t2.difficulty);
                }
            });
            
            
            // For each task, how much max profit it can get
            int[] maxProfit = new int[n];
            int max = 0;
            for(int i = 0; i < n; i++){
                max = Math.max(tasks[i].profit, max);
                maxProfit[i] = max;
            }
            
            
            int total = 0;
            int i = 0;
            Arrays.sort(worker);
            
            for(int j = 0; j < worker.length; j++){
                // Find the most difficult task the worker can handle
                while(i < n - 1 && worker[j] >= tasks[i + 1].difficulty){
                    i++;
                }
                
                // Check if worker can accomplish the task
                if(worker[j] >= tasks[i].difficulty) total += maxProfit[i];
            }
            
            return total;
            
        }
        
        class Task{
            int difficulty;
            int profit;
            
            public Task(int difficulty, int profit){
                this.difficulty = difficulty;
                this.profit = profit;            
            }
            
        }
    }
}
