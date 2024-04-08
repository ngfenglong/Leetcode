class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int p = 0;
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < students.length; i++){
            queue.add(i);
        }
        
        while(p < sandwiches.length){
            int stud = queue.poll();            
            if(students[stud] == sandwiches[p]) {
                p++;
                count = 0;
            }
            else {
                count++;
                queue.add(stud);
            }
            if(count == queue.size()) break;
        }
        return sandwiches.length - p;
    }
}