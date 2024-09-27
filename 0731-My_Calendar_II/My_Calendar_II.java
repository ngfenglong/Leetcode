class MyCalendarTwo {
    List<int[]> bookings = new ArrayList<>();
    List<int[]> overlappedBookings = new ArrayList<>();
    
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        for(int[] session: overlappedBookings){
            if(isOverlapped(start, end, session[0], session[1])) return false;
        }
        
        for(int[] session: bookings){
            if(isOverlapped(start, end, session[0], session[1])){
                overlappedBookings.add(getOverlap(start, end, session[0], session[1]));
            }
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
    
    private boolean isOverlapped(int start1, int end1, int start2, int end2){
        return Math.max(start1, start2) < Math.min(end1, end2);
    }
    
    private int[] getOverlap(int start1, int end1, int start2, int end2){
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }
    
    
}
