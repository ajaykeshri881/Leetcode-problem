class Solution {
    public int findGCD(int[] arr) {
        int n=arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        while(min!=0){
            int rem=max%min;
            max=min;
            min=rem;
        }
    return max;
    }
}