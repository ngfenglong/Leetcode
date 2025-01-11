
class ExcelSheetColumnNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int cols = 0;
            
            for(int i = columnTitle.length() - 1; i >= 0; i--){
                int pow = (columnTitle.length() - 1 - i);            
                int temp = (int)Math.pow(26, pow) * ((columnTitle.charAt(i) - 'A') + 1);
                cols += temp;
            }
            
            return cols;
        }
    }
}
