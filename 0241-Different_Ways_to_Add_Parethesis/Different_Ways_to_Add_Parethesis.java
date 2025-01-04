import java.util.*;

class Solution {
    HashMap<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        if (expression.length() == 0) return list;
        
        if(expression.length() == 1) {
            list.add(Integer.parseInt(expression));
            return list;
        }
        
        if(expression.length() == 2 && Character.isDigit(expression.charAt(0))){
            list.add(Integer.parseInt(expression));
            return list;
        }
        
        if(memo.containsKey(expression)) return new ArrayList<>(memo.get(expression));
        
        for(int i = 0; i < expression.length(); i++){
            char operation = expression.charAt(i);
            if(Character.isDigit(operation)) continue;
            
            List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
            
            for(Integer left: leftList){
                for(Integer right: rightList){
                    list.add(calculate(left, right, operation));
                }
            }
        } 
        
        memo.put(expression, list);
        return list;
        
    }
    
    private int calculate(int i1, int i2, char operation){
        if(operation == '+'){
            return i1 + i2;
        }
        else if(operation == '-'){
            return i1 - i2;
        }
        else{
            return i1 * i2;   
        }
    }
}