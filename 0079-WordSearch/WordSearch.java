
class WordSearch {
    class Solution {
        int m;
        int n;
        char[][] board;
        int[][] directions = {new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0, -1}};
        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.m = board.length;
            this.n = board[0].length;
            char[] wordArr = word.toCharArray();
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(checkWord(new boolean[m][n], i, j, wordArr, 0)){
                        return true;
                    }
                }
            }
            
            return false;
        }
        
        private boolean checkWord(boolean[][] visited, int x, int y, char[] word, int idx){
            if(idx == word.length) return true;
            
            if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || word[idx] != board[x][y]) return false;
            
            visited[x][y] = true;
            for(int[] direction: directions){
                if(checkWord(visited, x + direction[0], y + direction[1], word, idx + 1)){
                    return true;
                }
            }
            
            visited[x][y] = false;
            return false;
        }
    }
}
