class Solution {
    public int singleNonDuplicate(int[] arr) {
        int lo=0;
        int hi=arr.length-1;
        //boundry check

        if(hi==0){
            return arr[0];
        }else if(arr[0]!=arr[1]){
            return arr[0];
        }else if(arr[hi]!=arr[hi-1]){
            return arr[hi];
        }
// bs
while(lo<=hi){

         int mid = lo + (hi - lo) / 2;
        if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
            return arr[mid];
        } else if((mid%2==0 && arr[mid]==arr[mid-1]) || (mid%2!=0 && arr[mid]==arr[mid+1])){
            hi=mid-1;
        }else{
            lo=mid+1;
        }
}
return -1;
    }
}