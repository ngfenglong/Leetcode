class Solution {
    List<Integer> answer = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        int highDigitCount = 0;
        int lowDigitCount = 0;
        
        int currentLow = low;
        int currentHigh = high;
        
        while(currentLow > 0){
            currentLow /= 10;
            lowDigitCount++;
        }
        
        while(currentHigh > 0){
            currentHigh /= 10;
            highDigitCount++;
        }
        
        for(int digitCount = lowDigitCount; digitCount <= highDigitCount; digitCount++){
            generateSequentialDigits(low, high, digitCount);
        }
        
        return answer;
    }
    
    private void generateSequentialDigits(int low, int high, int digitCount){
        for(int startDigit = 1; startDigit <= 10 - digitCount; startDigit++){
            int num = startDigit;
            for(int nextDigit = 1; nextDigit < digitCount ; nextDigit++){
                num *= 10;
                num += (startDigit + nextDigit);
            }
            if (num < low) continue;
            else if(num <= high) answer.add(num);
            else return;
        }
    }
}