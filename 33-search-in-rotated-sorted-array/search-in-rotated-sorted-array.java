class Solution {
    public int search(int[] arr, int target) {
        int n=arr.length;
        int lo=0,hi=n-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<=arr[hi]) {  //right side 
            if(arr[mid]<target && arr[hi]>=target) lo=mid+1;
            else hi=mid-1;
            }
            else {  //left side
            if(arr[lo]<=target && arr[mid]>target) hi=mid-1;
            else lo=mid+1;
            }
    }
    return -1;
}
}