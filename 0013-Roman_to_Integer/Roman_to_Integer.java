class Solution {
    public int romanToInt(String s) {
        int idx = 0; 
        int sum = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == 'I'){
               int temp = idx;

                int amt = 0;
                while(temp < s.length() && s.charAt(temp) == 'I'){
                    amt += 1;
                    temp++;
                }
                if(temp < s.length() && s.charAt(temp) == 'V'){
                    sum += 4;
                    temp++;
                }
                else if(temp < s.length() && s.charAt(temp) == 'X'){
                    sum += 9;
                    temp++;
                }
                else{
                    sum += amt;
                }
                idx = temp;
                
            }
            else if(s.charAt(idx) == 'V'){
                sum += 5;
                idx++;
            }
            else if(s.charAt(idx) == 'X'){
                int temp = idx;
                
                int amt = 0;
                while(temp < s.length() && s.charAt(temp) == 'X'){
                    amt += 10;
                    temp++;
                }
                if(temp < s.length() && s.charAt(temp) == 'L'){
                    sum += 40;
                    temp++;
                }
                else if(temp < s.length() && s.charAt(temp) == 'C'){
                    sum += 90;
                    temp++;
                }
                else{
                    sum += amt;
                }
                idx = temp;
            }
            else if(s.charAt(idx) == 'L'){
                sum += 50;
                idx++;
            }
            else if(s.charAt(idx) == 'C'){
                int temp = idx;
                
                int amt = 0;
                while(temp < s.length() && s.charAt(temp) == 'C'){
                    amt += 100;
                    temp++;
                }
                if(temp < s.length() && s.charAt(temp) == 'D'){
                    sum += 400;
                    temp++;
                }
                else if(temp < s.length() && s.charAt(temp) == 'M'){
                    sum += 900;
                    temp++;
                }
                else{
                    sum += amt;
                }
                idx = temp;
            }
            else if(s.charAt(idx) == 'D'){
                sum += 500;
                idx++;
            }
            else{
                sum += 1000;
                idx++;
            }
            
            
        }
        
        return sum;
    }
}