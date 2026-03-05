class Solution {
    public int minOperations(String s) {
        int n = s.length(), count_a = 0;
        
        for (int i = 0; i < n; i++) {
        	char expected;
        	
        	if (i % 2 == 0) {
        		expected = '0';
        	} else {
        		expected = '1';
        	}
        	
        	if (s.charAt(i) != expected) {
        		count_a++;
        	}
        }
        
        int count_b = n - count_a;
        
        return Math.min(count_a, count_b);
    }
}