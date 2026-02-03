class Solution {
    public int removeDuplicates(int[] arr) {
        int i=0,j=0;
        while(i<arr.length){
            if(arr[i]==arr[j]){
                i++;
            }
            else{
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }
}