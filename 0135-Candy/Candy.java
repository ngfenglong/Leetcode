
class Candy {
    class Solution {
        public int candy(int[] ratings) {
            int[] toLeft = new int[ratings.length];
            int[] toRight = new int[ratings.length];
            toLeft[ratings.length - 1] = 1;
            toRight[0] = 1;
            
            
            for(int i = 1; i < ratings.length; i++){
                toRight[i] = ratings[i] > ratings[i-1] ? toRight[i - 1] + 1 : 1;
            }
            
            for(int i = ratings.length - 2; i >= 0; i--){
                toLeft[i] = ratings[i] > ratings[i + 1] ? toLeft[i + 1] + 1 : 1;
            }
            
            int count = 0;
            for(int i = 0; i < ratings.length; i++){
                count += Math.max(toLeft[i], toRight[i]);
            }
            return count;
        }
    }
    
}
