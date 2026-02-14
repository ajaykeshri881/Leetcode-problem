// class Solution {
//     public boolean isStrictlyPalindromic(int n) {
//         return false;
//     }
// }

class Solution {

    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; base++) {
            String converted = toBase(n, base);
            if (!isPalindrome(converted)) {
                return false;
            }
        }
        return true;
    }

    private String toBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
