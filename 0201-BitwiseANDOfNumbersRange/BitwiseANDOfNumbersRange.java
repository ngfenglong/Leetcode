
class BitwiseANDOfNumbersRange {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int bitShifted = 0;
            while(left < right){
                left >>= 1;
                right >>= 1;
                bitShifted++;
            }
            
            
            return left << bitShifted;
        }
    }
}
