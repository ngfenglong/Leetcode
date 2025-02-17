public class LetterTilePoosibilities {
    class Solution {
        public int numTilePossibilities(String tiles) {
            int[] frequencies = new int[26];
    
            for(int i = 0 ; i < tiles.length(); i++){
                int idx = tiles.charAt(i) - 'A';
                frequencies[idx]++;
            }
    
            return countPermutations(frequencies);
        }
    
        private int countPermutations(int[] frequencies){
            int count = 0;
            for(int i = 0; i < frequencies.length; i++){
                if(frequencies[i] == 0) continue;
    
                count++;
                frequencies[i]--;
                count += countPermutations(frequencies);
                frequencies[i]++;
            }
    
            return count;
        }
    }
    
}