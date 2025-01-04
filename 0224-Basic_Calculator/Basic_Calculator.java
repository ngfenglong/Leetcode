import java.util.*;

class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        
        char[] charArr = s.toCharArray();
        
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        
        int i = 0;
        while(i < charArr.length){
            if(charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '('){
                if(charArr[i] == '-' && (i == 0 || charArr[i - 1] == '(')){
                    operands.push(0);
                }
                
                operators.push(charArr[i]);
            } 
            // Check character after ( and when - appear, 
            else if (isDigit(charArr[i])) {
                int num = charArr[i] - '0';
                while(i < charArr.length - 1 && isDigit(charArr[i + 1])){
                    num *= 10;
                    num += (charArr[++i] - '0');
                }
                operands.push(num);
            }
            else if (charArr[i] == ')'){
                // Special case to handle --> Start with negative number (-1 + 2)
                Stack<Character> tempOperators = new Stack<Character>();
                Stack<Integer> tempOperands = new Stack<Integer>();
                while(operators.peek() != '('){
                    tempOperators.push(operators.pop());
                    tempOperands.push(operands.pop());
                }
                
                int op1 = operands.pop();
                operators.pop();
                
                while(!tempOperators.isEmpty()){
                    int op2 = tempOperands.pop();
                    op1 = calculate(op1, op2, tempOperators.pop());
                }
                
                operands.push(op1);
            }
            i++;
        }
        
        Stack<Character> tempOperators = new Stack<Character>();
        Stack<Integer> tempOperands = new Stack<Integer>();
        while(!operators.isEmpty()){
            tempOperators.push(operators.pop());
            tempOperands.push(operands.pop());
        }

        int op1 = operands.pop();

        while(!tempOperators.isEmpty()){
            int op2 = tempOperands.pop();
            op1 = calculate(op1, op2, tempOperators.pop());
        }
        
        return op1;
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
    private int calculate(int op1, int op2, char operator){ 
        if(operator == '+'){
            return op1 + op2;
        }
        
        else{
            return op1 - op2;
        }
    }
    
}