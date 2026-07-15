class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}



// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         int sumOdd = 0, sumEven = 0;

//         for (int i = 1; i <= 2 * n; i++) {
//             if (i % 2 == 0)
//                 sumEven += i;
//             else
//                 sumOdd += i;
//         }

//         return gcd(sumOdd, sumEven);
//     }

//     private int gcd(int a, int b) {
//         while (b != 0) {
//             int temp = b;
//             b = a % b;
//             a = temp;
//         }
//         return a;
//     }
// }