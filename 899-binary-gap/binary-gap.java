class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int maxDist = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // check last bit
                if (prev != -1) {
                    maxDist = Math.max(maxDist, position - prev);
                }
                prev = position;
            }
            n >>= 1;  // right shift
            position++;
        }

        return maxDist;
    }
}

/* class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int maxDist = 0;
        int position = 0;

        while (n > 0) {
            if ((n % 2) == 1) {
                if (prev != -1) {
                    maxDist = Math.max(maxDist, position - prev);
                }
                prev = position;
            }
            n = n / 2;
            position++;
        }
        return maxDist;
    }
} */



/* class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int prev = -1;
        int maxDist = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (prev != -1) {
                    maxDist = Math.max(maxDist, i - prev);
                }
                prev = i;
            }
        }
        return maxDist;
    }   
} 

//Time Complexity: O(log n)
// Space Complexity: O(log n)

*/