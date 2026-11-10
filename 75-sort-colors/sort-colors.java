class Solution {
    public void sortColors(int[] arr) {
        int n=arr.length;
        int zero=0;
        int one=0;
        int two=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0) zero++;
            if(arr[i]==1) one++;
            if(arr[i]==2) two++;
        }
        for(int i=0;i<zero;i++){
            arr[i]=0;
        }
        for(int i=zero;i<zero+one;i++){
            arr[i]=1;
        }
        for(int i=zero+one;i<n;i++){
            arr[i]=2;
        }
    }
}