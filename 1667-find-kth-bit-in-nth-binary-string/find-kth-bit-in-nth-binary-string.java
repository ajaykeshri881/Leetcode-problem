class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int mid = 1 << (n - 1);   // 2^(n-1)
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        
        return findKthBit(n - 1, 2 * mid - k) == '0' ? '1' : '0';
    }
}



/* class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int length = (1 << n) - 1;
        int mid = (length / 2) + 1;
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            int mirror = length - k + 1;
            char ch = findKthBit(n - 1, mirror);
            return ch == '0' ? '1' : '0';
        }
    }
}

 */



// class Solution {
//     public char findKthBit(int n, int k) {
//         String s = "0";
        
//         for (int i = 2; i <= n; i++) {
//             StringBuilder sb = new StringBuilder();
            
//             for (int j = s.length() - 1; j >= 0; j--) {
//                 char ch = s.charAt(j);
//                 sb.append(ch == '0' ? '1' : '0');
//             }
            
//             s = s + "1" + sb.toString();
//         }
        
//         return s.charAt(k - 1);
//     }
// }