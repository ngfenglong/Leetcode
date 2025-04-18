public class CountAndSay {
    class Solution {
        public String countAndSay(int n) {
            String result = "1";
            StringBuilder sb = new StringBuilder();
            n--;

            while (n > 0) {
                sb = new StringBuilder();
                int i = 0;

                while (i < result.length()) { // string length
                    int count = 1;
                    char c = result.charAt(i);
                    while (i < result.length() - 1 && result.charAt(i + 1) == c) {
                        count++;
                        i++;
                    }

                    sb.append("" + count);
                    sb.append(c);
                    i++;
                }

                n--;
                result = sb.toString();
            }

            return result;
        }
    }

}