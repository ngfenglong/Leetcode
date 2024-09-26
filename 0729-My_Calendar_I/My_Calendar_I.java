class MyCalendar {
    PriorityQueue<int[]> bookings;
    
    public MyCalendar() {
        bookings = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });    
    }
    
    public boolean book(int start, int end) {
        end--;
        for(int[] slot: bookings){
            if(
                (end >= slot[0] && end <= slot[1]) || 
                (start >= slot[0] && start <= slot[1]) ||
                (start <= slot[0] && end >= slot[1]) || 
                (start >= slot[0] && end <= slot[1])
            ) {
                return false;      
            }   
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
}