
class FractionAdditionAndSubtraction {
    class Solution {
        public String fractionAddition(String expression) {
            int numerator = 0;
            int denominator = 1;
            
            int i = 0;
            while(i < expression.length()){
                boolean isPositive = true;
                
                // Handle sign
                if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                    if(expression.charAt(i) == '-') isPositive = false;
                    i++;
                }
                
                int localNumerator = 0;
                int localDenominator = 0;
                while(Character.isDigit(expression.charAt(i))){
                    localNumerator *= 10;
                    localNumerator += (expression.charAt(i) - '0');
                    i++;
                }
                
                if(!isPositive) localNumerator *= -1;
                
                // Skip divisor
                i++;
                while(i < expression.length() && Character.isDigit(expression.charAt(i))){
                    localDenominator *= 10;
                    localDenominator += (expression.charAt(i) - '0');
                    i++;
                }
                
                numerator = numerator * localDenominator + localNumerator * denominator;
                denominator = denominator * localDenominator;
            }
            
            
            int divisor = Math.abs(findCommonDivisor(numerator, denominator));
            numerator /= divisor;
            denominator /= divisor;
            
            return numerator + "/" + denominator;
        }
        
        private int findCommonDivisor(int a, int b) {
            if(a == 0) return b;
            
            return findCommonDivisor(b % a, a);
        }
    }
}
