class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        if(num >= 1000000000){
            int temp = num / 1000000000;
            sb.append(getCounter(temp));
            sb.append(" Billion ");
            
            num = num % 1000000000; 
        }
        if(num >= 1000000){
            int temp = num / 1000000;
            sb.append(getCounter(temp));
            sb.append(" Million ");
            
            num = num % 1000000;
        }
        if(num >= 1000){
            int temp = num / 1000;
            sb.append(getCounter(temp));
            sb.append(" Thousand ");
            
            num = num % 1000;
        }
        if(num > 0){
            sb.append(getCounter(num));    
        }
        
        return sb.toString().trim();
    }
    
    
    private String getCounter(int num){
        if(num >= 100){
            int hundredth = num / 100;
            int tens = num % 100;
            return (getCounter(hundredth) + " Hundred " + getCounter(tens)).trim();
        }else if(num >= 10){
            if(num == 10) return "Ten";
            if(num == 11) return "Eleven";
            else if(num == 12) return "Twelve";
            else if(num == 13) return "Thirteen";
            else if(num == 14) return "Fourteen";
            else if(num == 15) return "Fifteen";
            else if(num == 16) return "Sixteen";
            else if(num == 17) return "Seventeen";
            else if(num == 18) return "Eighteen";
            else if(num == 19) return "Nineteen";
            else if(num >= 20 && num <= 29) {
                return ("Twenty" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 30 && num <= 39) {
                return ("Thirty" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 40 && num <= 49) {
                return ("Forty" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 50 && num <= 59) {
                return ("Fifty" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 60 && num <= 69) {
                return ("Sixty" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 70 && num <= 79) {
                return ("Seventy" + " "+ getCounter(num % 10)).trim() ;
            }
            else if(num >= 80 && num <= 89) {
                return ("Eighty" + " "+ getCounter(num % 10)).trim() ;
            }
            else {
                return ("Ninety" + " "+ getCounter(num % 10)).trim() ;
            }
        }
        else {
            if(num == 1) return "One";
            if(num == 2) return "Two";
            if(num == 3) return "Three";
            if(num == 4) return "Four";
            if(num == 5) return "Five";
            if(num == 6) return "Six";
            if(num == 7) return "Seven";
            if(num == 8) return "Eight";
            if(num == 9) return "Nine";
            else return "";
        }
    }
}