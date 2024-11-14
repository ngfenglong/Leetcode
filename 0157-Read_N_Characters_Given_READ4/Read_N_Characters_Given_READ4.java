public interface Reader4 {
    public int read4(char[] buf4);
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        List<Character> tempList = new ArrayList<>();
        int count = -1;
        
        
        while(count != 0 && n > 0){
            count = read4(buf);
            
            for(int i = 0; i < count && n > 0; i++){
                n--;
                tempList.add(buf[i]);
            }
        }
        
        
        for(int i = 0; i < tempList.size(); i++){
            buf[i] = tempList.get(i);
        }
        
        return tempList.size();
    }
}