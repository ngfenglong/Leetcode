
class FilingBookShelves {
    class Solution {
        Integer[][] dp;
        public int minHeightShelves(int[][] books, int shelfWidth) {
            dp = new Integer[books.length][shelfWidth + 1];
            
            int n = books.length;
            return getMinHeights(books, n - 1,  shelfWidth, 0, 0);
        }
        
        private int getMinHeights(int[][] books, int idx, int shelfWidth, int currWidth, int currHeight){
            if(idx < 0) return currHeight;
            if(dp[idx][currWidth] != null) return dp[idx][currWidth];
                
            int w = books[idx][0];
            int h = books[idx][1];
            
            int minHeight = Integer.MAX_VALUE;
            if(w + currWidth <= shelfWidth){
                minHeight = Math.min(getMinHeights(books, idx - 1, shelfWidth, currWidth + w, Math.max(currHeight, h)), minHeight);
            }
            
            minHeight = Math.min(minHeight, getMinHeights(books, idx - 1, shelfWidth, w, h) + currHeight);
            dp[idx][currWidth] = minHeight;   
         
            return minHeight;
        }
    }
}
