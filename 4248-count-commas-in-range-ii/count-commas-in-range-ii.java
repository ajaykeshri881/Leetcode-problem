class Solution {
    public long countCommas(long n) {
        long comma=0;
        long power=1000;
        while(power<=n){
            comma+=n-power+1;
            power*=1000;
        }
        return comma;
    }
}