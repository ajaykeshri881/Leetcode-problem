/* class Solution {
    int reverse(int n){
        int rev = 0;
        while(n>0){
            int digit =n%10;
            rev= rev*10+digit;
            n/=10;
        }
        return rev;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
} */

class Solution {
    public int mirrorDistance(int n) {
        int rev = 0, temp = n;

        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        return Math.abs(n - rev);
    }
}