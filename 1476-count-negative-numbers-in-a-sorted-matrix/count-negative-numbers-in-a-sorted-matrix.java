class Solution {
    public int countNegatives(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int firstNegative = m;
            for (int left = 0, right = m - 1; left <= right; ) {
                int mid = left + (right - left) / 2;

                if (arr[i][mid] < 0) {
                    firstNegative = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += (m - firstNegative);
        }
        return count;
    }
}


// class Solution {
//     public int countNegatives(int[][] arr) {
//         int n=arr.length;
//         int m=arr[0].length;
//         int count=0;

//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(arr[i][j]<0){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
