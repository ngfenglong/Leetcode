import java.util.*;

class BasicCalculatorIII {
    
    class Solution {
        public int calculate(String s) {
            // Convert s -> to charArr        
            // If it is '+', '-' --> calculate later --> pop into a temp stack to calculate it in order
            // If it is * and / --> calculate immediately --> having ( after *, /
            // If it is '( )', execute after it closes --> Special case, having *, / before (
            
            char[] charArr = s.toCharArray();
            int i = 0; 
            
            Stack<Integer> operands = new Stack<>();
            Stack<Character> operators = new Stack<>();
            
            while (i < charArr.length) {
                if(charArr[i] == '(' || charArr[i] == '+' || charArr[i] == '-'){
                    operators.push(charArr[i]);
                }
                else if(charArr[i] == '*' || charArr[i] == '/'){
                    // Special case, next char could be (
                    char operator = charArr[i];
                    if(isDigit(charArr[i + 1])){
                        int operand = 0;
                        while(i < charArr.length - 1 && isDigit(charArr[i + 1])){
                            operand *= 10;
                            operand += charArr[++i] - '0';
                        }
                        operands.push(calculate(operands.pop(), operand, operator));    
                    }
                    else {
                        operators.push(operator);
                    }                
                }
                else if (charArr[i] == ')'){
                    Stack<Integer> tempOperands = new Stack<Integer>();
                    Stack<Character> tempOperators = new Stack<Character>();
                    
                    tempOperands.push(operands.pop());
                    while(operators.peek() != '('){
                        tempOperands.push(operands.pop()); 
                        tempOperators.push(operators.pop()); 
                    }
                    
                    int val = calculateEquation(tempOperands, tempOperators);
                    operators.pop();
                    
                    // check if the operator before is * or /
                    if(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')){
                        val = calculate(operands.pop(), val, operators.pop());
                    }
                    
                    operands.push(val);                
                }
                else {
                    int operand = charArr[i] - '0';
                    while(i < charArr.length - 1 && isDigit(charArr[i + 1])){
                        operand *= 10;
                        operand += charArr[++i] - '0';
                    }
                    operands.push(operand);
                }
                i++;
            }
            
            Stack<Integer> tempOperands = new Stack<Integer>();
            Stack<Character> tempOperators = new Stack<Character>();
            
            if(operators.isEmpty()) return operands.pop();
            
            tempOperands.push(operands.pop()); 
            while(!operators.isEmpty()){
                tempOperands.push(operands.pop()); 
                tempOperators.push(operators.pop()); 
            }
            
            return calculateEquation(tempOperands, tempOperators);
        }
        
        private int calculateEquation(Stack<Integer> operands, Stack<Character> operators){
            int val = operands.pop();
            while(!operators.isEmpty()){
                val = calculate(val, operands.pop(), operators.pop());
            }
            return val;
        }
        
        private boolean isDigit (char c) {
            return c >= '0' && c <='9';
        }
        
        private int calculate(int i1, int i2, char operator){
            if(operator == '+') {
                return i1 + i2;
            }        
            else if(operator == '-') {
                return i1 - i2;
            }
            else if(operator == '*') {
                return i1 * i2;
            }
            else {
                return i1 / i2;
            }
        }
    }
}
