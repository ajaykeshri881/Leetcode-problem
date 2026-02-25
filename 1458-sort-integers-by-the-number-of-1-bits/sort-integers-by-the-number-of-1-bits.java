class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int v = 0;
        int[] ans = new int[n] ;

        for(int i=0;i<14;i++){
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(Integer.bitCount(arr[j]) == i){
                    t.add(arr[j]);
                }
            }
            Collections.sort(t);
            for(int k : t){
                ans[v++] = k;
            }
        }
        return ans;
    }
}