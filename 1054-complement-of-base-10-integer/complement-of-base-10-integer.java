class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 0;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        return mask ^ n;
    }
}



/* class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        String binary = Integer.toBinaryString(n);
        StringBuilder flipped = new StringBuilder();

        for (char c : binary.toCharArray()) {
            if (c == '0') {
                flipped.append('1');
            } else {
                flipped.append('0');
            }
        }

        return Integer.parseInt(flipped.toString(), 2);
    }
} */

