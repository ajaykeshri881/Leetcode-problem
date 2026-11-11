class Solution {
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] arr) {
        int n=arr.length;
        int lo=0,mid=0,hi=n-1;
        while(mid<=hi){
            if(arr[mid]==0){
                swap(arr,lo,mid);
                lo++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,hi);
                hi--;
            }
        }
    }
}