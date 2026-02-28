class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1_000_000_007;
    long res = 0;
    int bits = 0;
    int nextPow = 1;

    for (int i = 1; i <= n; i++) {

      if (i == nextPow) {
        bits++;
        nextPow <<= 1;
      }

      res = ((res << bits) + i) % MOD;
    }

    return (int) res;
  }
}

/* class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1000000007;
    long ans = 0;
    int bitLength = 0;

    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        bitLength++;
      }

      ans = ((ans << bitLength) + i) % MOD;
    }

    return (int) ans;
  }
} */


// class Solution {
//   public int concatenatedBinary(int n) {
//     final int MOD = 1_000_000_007;
//     long ans = 0;

//     for (int i = 1; i <= n; ++i)
//       ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;
//     return (int) ans;
//   }

//   private int numberOfBits(int n) {
//     return (int) (Math.log(n) / Math.log(2)) + 1;
//   }
// }