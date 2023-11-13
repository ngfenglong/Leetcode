class Solution {
    public String sortVowels(String s) {
        int[] vowels = new int[10]; // Array to count vowels
        
        for (char c : s.toCharArray()) {
            int idx = getVowelIndex(c);
            if (idx != -1) {
                vowels[idx]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                for (int i = 0; i < vowels.length; i++) {
                    if (vowels[i] > 0) {
                        sb.append(getVowelFromIndex(i));
                        vowels[i]--;
                        break;
                    }
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }

    private int getVowelIndex(char c) {
        String vowels = "AEIOUaeiou";
        return vowels.indexOf(c);
    }

    private char getVowelFromIndex(int idx) {
        String vowels = "AEIOUaeiou";
        return vowels.charAt(idx);
    }
}
