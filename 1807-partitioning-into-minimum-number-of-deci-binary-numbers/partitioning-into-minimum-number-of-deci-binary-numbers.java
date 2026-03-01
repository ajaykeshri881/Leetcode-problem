class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            
            if (maxDigit == 9) {
                return 9;   
            }
        }
        
        return maxDigit;
    }
}

/* class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
            
            if (maxDigit == 9) {
                return 9; 
            }
        }
        
        return maxDigit;
    }
} */


/* class Solution {
    public int minPartitions(String n) {
        int count = 0;
        char[] digits = n.toCharArray();
        
        while (true) {
            boolean allZero = true;
            
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > '0') {
                    digits[i]--;   // subtract 1
                    allZero = false;
                }
            }
            
            if (allZero) break;
            count++;
        }
        
        return count;
    }
} */