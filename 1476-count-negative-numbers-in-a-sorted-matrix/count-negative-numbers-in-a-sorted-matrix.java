class Solution {
    public int countNegatives(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}