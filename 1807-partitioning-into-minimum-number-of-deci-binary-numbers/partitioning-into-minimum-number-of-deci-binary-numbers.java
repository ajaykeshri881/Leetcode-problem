class Solution {
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
}