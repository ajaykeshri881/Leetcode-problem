class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums1)set.add(i);
        int ans=-1;
        for(int i:nums2){
            if(set.contains(i)){
                ans=i;
                break;
            }
        }
        return ans;
    }
}