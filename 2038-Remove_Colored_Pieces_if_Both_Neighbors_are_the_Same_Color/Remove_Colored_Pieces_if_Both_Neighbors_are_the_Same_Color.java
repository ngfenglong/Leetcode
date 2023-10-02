class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() < 3) return false;
        
        int[] removableColors = new int[2];
        
        int count = 0;
        char currColor = colors.charAt(0);
        
        for(int i = 0; i < colors.length(); i++){
            if(currColor == colors.charAt(i)){
                count++;
            } else {
                if(count > 2) removableColors[currColor - 'A'] += (count - 2);
                currColor = colors.charAt(i);
                count = 1;
            }
        }
        
        if(count > 2) removableColors[currColor - 'A'] += (count - 2);
        
        
        return removableColors[0] > removableColors[1];
    }
}