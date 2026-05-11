// class Solution {
//     public int[] separateDigits(int[] nums) {
//         List<Integer>ans=new ArrayList<>();
//         for(int val:nums){
//             List<Integer>cur=new ArrayList<>();
//             while(val>0){
//                 cur.add(val%10);
//                 val/=10;
//             }
//             ans.addAll(cur.reversed());
//         }
//         return ans.stream().mapToInt(Integer::intValue).toArray();
//     }
// }


class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> supp = new ArrayList<>();
        for(int i:nums){
            String s = Integer.toString(i);
            char [] arr = s.toCharArray();
            for(char k:arr){
                supp.add(k-'0');
            }
        }
        int [] ans = new int [supp.size()];
        for(int i=0;i<supp.size();i++){
            ans[i] = supp.get(i);
        }
        return ans;
    }
}